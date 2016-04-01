package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispBool extends LispValue {
	public boolean bool;
	public HashMap<String, LispValue> env;
	
	public LispBool(HashMap<String, LispValue> env, boolean b) {
		bool = b;
		this.env = env;
	}

	@Override
	public LispValue eval() {
		return this;
	}

	@Override
	public String show() {
		if (bool) {
			return "true";
		} else {
			return "false";
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
