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
		ArrayList<LispValue> b = applyArgs(body, args);
		for (int i = 0; i < b.size(); i++) {
			LispValue val = b.get(i).eval();
			b.set(i, val);
		}
		return b.get(b.size() - 1);
	}
	
	ArrayList<LispValue> applyArgs(ArrayList<LispValue> body,
			List<LispValue> args) {
		for (int i = 0; i < body.size(); i++) {
			LispValue val = body.get(i);
			if (val instanceof LispSymbol) {
				LispSymbol sym = (LispSymbol) val;
				if (params.contains(sym.symbol)) {
					int j = params.indexOf(sym.symbol);
					body.set(i, args.get(j));
				}
			}
		}
		return body;
	}

}
