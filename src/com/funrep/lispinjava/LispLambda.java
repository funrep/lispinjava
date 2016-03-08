package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LispLambda extends LispValue {
	ArrayList<String> params;
	ArrayList<LispValue> body;
	HashMap<String, LispValue> closure;
	
	public LispLambda() {
		
	}

	@Override
	LispValue eval() {
		
		return this;
	}

	@Override
	String show() {
		return null;
	}

	@Override
	LispValue apply(List<LispValue> args) {
		return null;
	}

}
