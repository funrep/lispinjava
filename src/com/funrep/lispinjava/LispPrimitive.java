package com.funrep.lispinjava;

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
		result.list.add(callBuiltIn(args));
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
			double sum1 = 0;
			for (LispValue val : args) {
				LispNumber num = (LispNumber) val;
				sum1 -= num.number;
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
