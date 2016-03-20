package com.funrep.lispinjava;

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
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		return "\"" + string + "\"";
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
