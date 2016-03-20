package com.funrep.lispinjava;

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
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		return "" + number;
	}

	@Override
	LispList apply(List<LispValue> args) {
		return null;
	}

	@Override
    HashMap<String, LispValue> getEnv() {
		return env;
    }

}
