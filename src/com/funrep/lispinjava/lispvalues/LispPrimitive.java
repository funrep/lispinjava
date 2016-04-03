package com.funrep.lispinjava.lispvalues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.funrep.lispinjava.errors.TypeError;

public class LispPrimitive extends LispValue {
	public String function;
	public HashMap<String, LispValue> env;
	
	public LispPrimitive(HashMap<String, LispValue> env, String func) {
		function = func;
		this.env = env;
	}

	@Override
	public LispValue eval() {
		return null;
	}

	@Override
	public String show() {
		return function;
	}

	@Override
	LispList apply(List<LispValue> args) {
		LispList result = new LispList(env);
		ArrayList<LispValue> evalArgs = new ArrayList<LispValue>();
		for (LispValue val : args) {
			evalArgs.add(val.eval());
		}
		result.list.add(callBuiltIn(evalArgs));
		return result;
	}
	
	public LispValue callBuiltIn(List<LispValue> args) {
		switch (function) {
		case "+":
			double sum = 0;
			for (LispValue val : args) {
				if (val instanceof LispNumber) {
					LispNumber num = (LispNumber) val;
					sum += num.number;
				} else {
					return new TypeError();
				}
			}
			return new LispNumber(env, sum);
		case "-":
			LispNumber n;
			double sum1;
			if (args.get(0) instanceof LispNumber) {
				n = (LispNumber) args.get(0);
				sum1 = n.number;
			} else {
				return new TypeError();
			}
			for (int i = 1; i < args.size(); i++) {
				if (args.get(i) instanceof LispNumber) {
					n = (LispNumber) args.get(i);
					sum1 -= n.number;
				} else {
					return new TypeError();
				}
			}
			return new LispNumber(env, sum1);
		case "equal?":
			if (args.get(0) instanceof LispBool) {
				if (args.get(1) instanceof LispBool) {
					LispBool bool1 = (LispBool) args.get(0);
					LispBool bool2 = (LispBool) args.get(1);
					return new LispBool(env, bool1.bool == bool2.bool);
				}
			} else if (args.get(0) instanceof LispNumber) {
				if (args.get(1) instanceof LispNumber) {
					LispNumber num1 = (LispNumber) args.get(0);
					LispNumber num2 = (LispNumber) args.get(1);
					return new LispBool(env, num1.number == num2.number);
				}
			} else if (args.get(0) instanceof LispString) {
				if (args.get(1) instanceof LispString) {
					LispString str1 = (LispString) args.get(0);
					LispString str2 = (LispString) args.get(1);
					return new LispBool(env, str1.string.equals(str2.string));
				}
			} else if (args.get(0) instanceof LispList) {
				if (args.get(1) instanceof LispList) {
					LispList lst1 = (LispList) args.get(0);
					LispList lst2 = (LispList) args.get(1);
					if (lst1.list.size() != lst2.list.size()) {
						return new LispBool(env, false);
					} else {
						for (int i = 0; i < lst1.list.size(); i++) {
							if (lst1.list.get(i) != lst2.list.get(i)) {
								return new LispBool(env, false);
							}
						}
						return new LispBool(env, true);
					}
				}
			}
			break;
		case "cons":
			LispList head = new LispList(env);
			if (args.get(1) instanceof LispNil) {
				head.list.add(args.get(0));
				return head;
			} else if (args.get(1) instanceof LispList) {
				head.list.add(args.get(0));
				LispList tail = (LispList) args.get(1);
				head.list.addAll(tail.list);
				return head;
			} else {
				return new TypeError();
			}
		case "head":
			if (args.get(0) instanceof LispList) {
				LispList lst = (LispList) args.get(0);
				if (lst.list.size() == 0) {
					return new LispNil(env);
				} else {
					return lst.list.get(0);
				}
			} else {
				return new TypeError();
			}
		case "tail":
			if (args.get(0) instanceof LispList) {
				LispList lst = (LispList) args.get(0);
				lst.list = new ArrayList<LispValue>(lst.list.subList(1, lst.list.size()));
				return lst;
			} else {
				return new TypeError();
			}
		}
		return null;
	}

	@Override
	public HashMap<String, LispValue> getEnv() {
	    return env;
    }
}
