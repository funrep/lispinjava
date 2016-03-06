package com.funrep.lispinjava;

import java.util.ArrayList;

public class LispString extends LispValue {
	public String string;

	public LispString(String s) {
		string = s;
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
	LispValue apply(ArrayList<LispValue> args) {
		return null;
	}

}
