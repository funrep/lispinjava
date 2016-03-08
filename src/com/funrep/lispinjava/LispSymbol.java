package com.funrep.lispinjava;

import java.util.List;

public class LispSymbol extends LispValue {
	public String symbol;

	public LispSymbol(String s) {
		symbol = s;
	}

	@Override
	LispValue eval() {
		return Environment.env.get(symbol);
	}

	@Override
	String show() {
		return symbol;
	}

	@Override
	LispValue apply(List<LispValue> args) {
		return null;
	}

}
