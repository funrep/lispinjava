package com.funrep.lispinjava;

import java.util.ArrayList;

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
	LispValue apply(ArrayList<LispValue> args) {
		return null;
	}

}
