package com.funrep.lispinjava;

import java.util.ArrayList;

public class LispList extends LispValue {
	public ArrayList<LispValue> list;
	
	public LispList() {
		list = new ArrayList<LispValue>();
	}

	@Override
	LispValue eval() {
		LispValue head = list.get(0);
		if (head.getClass().getSimpleName().equals("LispSymbol")) {
			LispSymbol sym = (LispSymbol) head;
			switch (sym.symbol) {
			case "quote":
				return list.get(1);
			case "define":
				LispSymbol var = (LispSymbol) list.get(1);
				LispValue val = list.get(2).eval();
				Environment.env.put(var.symbol, val);
				return val;
			case "if":
				LispBool pred = (LispBool) list.get(1).eval();
				LispValue conseq = list.get(2);
				LispValue alt = list.get(3);
				if (pred.bool) {
					return conseq.eval();
				} else {
					return alt.eval();
				}
			case "lambda":
				
				break;
			}
		}
		return null;
	}

	@Override
	String show() {
		if (list.size() == 0) {
			return "()";
		} else {
			String content = "";
			for (int i = 0; i < list.size() - 1; i++) {
				content += list.get(i).show() + " ";
			}
			content += list.get(list.size() - 1).show();
			return "(" + content + ")";
		}
	}

	@Override
	LispValue apply(ArrayList<LispValue> args) {
		return null;
	}

}
