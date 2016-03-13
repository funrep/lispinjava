package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.List;

public class LispPrimitive extends LispValue {
	String function;
	
	public LispPrimitive(String func) {
		function = func;
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
	ArrayList<LispValue> apply(List<LispValue> args) {
		ArrayList<LispValue> result = new ArrayList<LispValue>();
		result.add(callBuiltIn(args));
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
			return new LispNumber(sum);
		case "-":
			double sum1 = 0;
			for (LispValue val : args) {
				LispNumber num = (LispNumber) val;
				sum1 -= num.number;
			}
			return new LispNumber(sum1);
		}
		return null;
	}
}
