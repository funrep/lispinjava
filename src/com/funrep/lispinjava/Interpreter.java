package com.funrep.lispinjava;

import java.util.ArrayList;

public class Interpreter {

	public static void main(String[] args) {
		LispList expr = new LispList();
		expr.list.add(new LispSymbol("quote"));
		expr.list.add(new LispNumber(5));
		System.out.println(expr.show());
		System.out.println(expr.eval().show());
		LispList expr2 = new LispList();
		expr2.list.add(new LispSymbol("if"));
		expr2.list.add(new LispBool(true));
		expr2.list.add(new LispString("hello world"));
		expr2.list.add(new LispString("goodbye world"));
		System.out.println(expr2.show());
		System.out.println(expr2.eval().show());
		LispList expr3 = new LispList();
		expr3.list.add(new LispPrimitive("+"));
		expr3.list.add(new LispNumber(5));
		expr3.list.add(new LispNumber(10));
		expr3.list.add(new LispNumber(1));
		System.out.println(expr3.show());
		System.out.println(expr3.eval().show());
		ArrayList<String> ss = Parsing.tokenize("(1 2 3)");
		for (String s : ss) {
			System.out.println(s);
		}
		LispList expr4 = Parsing.parse(ss);
		System.out.println(expr4.show());
	}
}
