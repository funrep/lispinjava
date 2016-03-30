package com.funrep.lispinjava;

import java.util.HashMap;
import java.util.List;

public class LispNil extends LispValue {
	public HashMap<String, LispValue> env;

	public LispNil(HashMap<String, LispValue> env) {
		this.env = env;
	}
	
	@Override
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		return "nil";
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
