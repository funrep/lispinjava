package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispError extends LispValue {
	public String error;

	public LispError(String s) {
		error = s;
	}
	
	@Override
	public LispValue eval() {
		return this;
	}

	@Override
	public String show() {
		return "Error: " + error;
	}

	@Override
	LispList apply(List<LispValue> args) {
		return null;
	}

	@Override
	public HashMap<String, LispValue> getEnv() {
	    return null;
    }
}
