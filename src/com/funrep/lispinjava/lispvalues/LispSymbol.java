package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public class LispSymbol extends LispValue {
	public String symbol;
	HashMap<String, LispValue> env;

	public LispSymbol(HashMap<String, LispValue> env, String s) {
		symbol = s;
		this.env = env;
	}

	@Override
	public LispValue eval() {
		return env.get(symbol);
	}

	@Override
	public String show() {
		return symbol;
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
