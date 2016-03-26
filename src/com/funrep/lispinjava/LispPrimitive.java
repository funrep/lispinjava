package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LispPrimitive extends LispValue {
	public String function;
	public HashMap<String, LispValue> env;
	
	public LispPrimitive(HashMap<String, LispValue> env, String func) {
		function = func;
		this.env = env;
	}

	@Override
	LispValue eval() {
		return null;
	}

	@Override
	String show() {
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
				LispNumber num = (LispNumber) val;
				sum += num.number;
			}
			return new LispNumber(env, sum);
		case "-":
			LispNumber n = (LispNumber) args.get(0);
			double sum1 = n.number;
			for (int i = 1; i < args.size(); i++) {
				n = (LispNumber) args.get(i);
				sum1 -= n.number;
			}
			return new LispNumber(env, sum1);
		}
		return null;
	}

	@Override
    HashMap<String, LispValue> getEnv() {
	    return env;
    }
}
