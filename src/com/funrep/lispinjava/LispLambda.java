package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LispLambda extends LispValue {
	ArrayList<String> params;
	LispList body;
	HashMap<String, LispValue> closure;
	HashMap<String, LispValue> env;
	
	public LispLambda(HashMap<String, LispValue> env, ArrayList<String> params,
			LispList body) {
		this.params = params;
		this.body = body;
		closure = Environment.env; // ?
		this.env = env;
	}

	@Override
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		String content = "";
		if (params.size() == 0) {
			content += "()";
		} else {
			for (int i = 0; i < params.size() - 1; i++) {
				content += params.get(i) + " ";
			}
			content += params.get(params.size() - 1);
		}
		return "(lambda (" + content + ") ...)";
	}

	@Override
	LispList apply(List<LispValue> args) {
		for (int i = 0; i < params.size(); i++) {
			env.put(params.get(i), args.get(i));
		}
		return body;
	}
	
	ArrayList<LispValue> applyArgs(ArrayList<LispValue> body,
			List<LispValue> args) {
		for (int i = 0; i < body.size(); i++) {
			LispValue val = body.get(i);
			if (val instanceof LispSymbol) {
				LispSymbol sym = (LispSymbol) val;
				if (params.contains(sym.symbol)) {
					int j = params.indexOf(sym.symbol);
					body.set(i, args.get(j));
				}
			}
		}
		return body;
	}

	@Override
    HashMap<String, LispValue> getEnv() {
	    return env;
    }

}
