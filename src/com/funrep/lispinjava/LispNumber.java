package com.funrep.lispinjava;

import java.util.ArrayList;

public class LispNumber extends LispValue {
	public double number;

	public LispNumber(double n) {
		number = n;
	}

	@Override
	LispValue eval() {
		return this;
	}

	@Override
	String show() {
		return "" + number;
	}

	@Override
	LispValue apply(ArrayList<LispValue> args) {
		return null;
	}

}
