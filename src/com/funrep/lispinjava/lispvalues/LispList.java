package com.funrep.lispinjava.lispvalues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.funrep.lispinjava.errors.EvalError;

public class LispList extends LispValue {
	public ArrayList<LispValue> list;
	public HashMap<String, LispValue> env;
	
	public LispList(HashMap<String, LispValue> env) {
		list = new ArrayList<LispValue>();
		this.env = env;
	}

	@Override
    public LispValue eval() {
		LispValue head = list.get(0);
		if (head instanceof LispSymbol) {
			LispSymbol sym = (LispSymbol) head;
			switch (sym.symbol) {
			case "quote":
				return list.get(1);
			case "define":
				LispSymbol name = (LispSymbol) list.get(1);
				LispValue val = list.get(2);
				if (val instanceof LispList) {
					val = ((LispList) val).list.get(0).eval();
				} else {
					val = val.eval();
				}
				env.put(name.symbol, val);
				return val;
			case "set!":
				LispSymbol var = (LispSymbol) list.get(1);
				LispValue newVal = list.get(2).eval();
				env.remove(var.symbol);
				env.put(var.symbol, newVal);
				return newVal;
			case "if":
				LispBool pred = (LispBool) list.get(1).eval();
				LispValue conseq = list.get(2);
				LispValue alt = list.get(3);
				if (pred.bool) {
					return conseq.eval();
				} else {
					return alt.eval();
				}
			default:
				LispValue mapping = sym.eval();
				if (mapping instanceof LispPrimitive) {
					LispPrimitive func = (LispPrimitive) mapping;
					List<LispValue> args = list.subList(1, list.size());
					return func.apply(args).list.get(0);
				} else if (mapping instanceof LispLambda) {
					LispLambda lambda = (LispLambda) mapping;
					List<LispValue> args = list.subList(1, list.size());
					LispList body = lambda.apply(args);
					if (body.list.get(0) instanceof LispError) {
						return body.list.get(0);
					} else {
						return body.eval();
					}
				} else {
					break;
				}
			}
		} else if (head instanceof LispList) {
			LispList headList = (LispList) head;
			if (headList.list.get(0) instanceof LispLambda) {
				LispLambda lambda = (LispLambda) headList.list.get(0);
				List<LispValue> args = list.subList(1, list.size());
				LispList body = lambda.apply(args);
				env = lambda.env;
				if (body.list.get(0) instanceof LispError) {
					return body.list.get(0);
				} else {
					return body.eval();
				}
			}
		}
		return new EvalError();
	}

	@Override
	public String show() {
		if (list.size() == 0) {
			return "()";
		} else {
			String content = "";
			for (int i = 0; i < list.size() - 1; i++) {
				content += list.get(i).show() + " ";
			}
			content += list.get(list.size() - 1).show();
			return "(" + content + ")";
		}
	}

	@Override
	LispList apply(List<LispValue> args) {
		return null;
	}

	@Override
	public HashMap<String, LispValue> getEnv() {
	    return env;
    }

}
