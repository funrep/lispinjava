package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.List;

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
	ArrayList<LispValue> apply(List<LispValue> args) {
		return null;
	}

}
