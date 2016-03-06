package com.funrep.lispinjava;

import java.util.ArrayList;

public class LispBool extends LispValue {
	public boolean bool;
	
	public LispBool(boolean b) {
		bool = b;
	}

	@Override
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		if (bool) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	LispValue apply(ArrayList<LispValue> args) {
		return null;
	}

}
