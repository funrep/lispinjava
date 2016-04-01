package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispString extends LispValue {
	public String string;
	public HashMap<String, LispValue> env;

	public LispString(HashMap<String, LispValue> env, String s) {
		string = s;
		this.env = env;
	}
	
	@Override
	public LispValue eval() {
		return this;
	}

	@Override
	public String show() {
		return "\"" + string + "\"";
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
