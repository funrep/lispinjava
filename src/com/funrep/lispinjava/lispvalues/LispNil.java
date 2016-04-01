package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispNil extends LispValue {
	public HashMap<String, LispValue> env;

	public LispNil(HashMap<String, LispValue> env) {
		this.env = env;
	}
	
	@Override
	public LispValue eval() {
		return this;
	}

	@Override
	public String show() {
		return "nil";
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
