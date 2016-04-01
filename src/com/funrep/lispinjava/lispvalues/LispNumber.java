package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispNumber extends LispValue {
	public double number;
	public HashMap<String, LispValue> env;

	public LispNumber(HashMap<String, LispValue> env, double n) {
		number = n;
		this.env = env;
	}

	@Override
	public LispValue eval() {
		return this;
	}

	@Override
	public String show() {
		return "" + number;
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
