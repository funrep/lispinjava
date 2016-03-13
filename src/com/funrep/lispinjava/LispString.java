package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.List;

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
	ArrayList<LispValue> apply(List<LispValue> args) {
		return null;
	}

}
