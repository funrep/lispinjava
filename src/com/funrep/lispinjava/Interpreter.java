package com.funrep.lispinjava;

import java.util.List;
import java.util.Scanner;

public class Interpreter {

	public static void main(String[] args) {
		/* Environment.initEnv();
		String s = "((lambda (x) (- x x)) 5)";
		System.out.println(s);
		List<String> tokens = Parsing.tokenize(s);
		for (String str : tokens) {
			System.out.print(str + " ");
		}
		System.out.println("");
		LispList expr = Parsing.parse(Environment.env, tokens, 1).right;
		System.out.println(expr.getClass().getSimpleName());
		for (LispValue val : expr.list) {
			System.out.println(val.getClass().getSimpleName());
		}
		System.out.println(expr.show());
		System.out.println(expr.eval().show());*/
		repl();
	}
	
	public static void repl() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lisp In Java REPL");
		Environment.initEnv();
		String input, result;
		LispValue expr;
		do {
			System.out.print("> ");
			input = sc.nextLine();
			result = "";
			try {
				expr = Parsing.magic(Environment.env, input).eval();
				result = expr.show();
				Environment.env = expr.getEnv();
			} catch (Exception e){
				result = e.getMessage();
			}
			System.out.println(result);
		} while (input != "exit");
		sc.close();
	}
}
