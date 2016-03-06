package com.funrep.lispinjava;

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
	}
}
