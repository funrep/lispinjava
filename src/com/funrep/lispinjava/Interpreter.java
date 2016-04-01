package com.funrep.lispinjava;

import java.util.List;
import java.util.Scanner;

import com.funrep.lispinjava.lispvalues.LispList;
import com.funrep.lispinjava.lispvalues.LispValue;
import com.funrep.lispinjava.parsing.Parsing;

public class Interpreter {

	public static void main(String[] args) {
			repl();
	}
	
	public static void repl() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lisp In Java REPL");
		Environment.initEnv();
		String input, result;
		LispValue expr;
		while (true) {
			System.out.print("> ");
			input = sc.nextLine();
			if (input.equals("exit")) {
				break;
			} else if (!input.equals("")) {
				result = "";
				try {
					expr = Parsing.magic(Environment.env, input).eval();
					result = expr.show();
					Environment.env = expr.getEnv();
				} catch (Exception e) {
					result = e.getMessage();
				}
				System.out.println(result);
			}
		}
		sc.close();
	}
	
	public static void debug(String s) {
		Environment.initEnv();
		System.out.println(s);
		List<String> tokens = Parsing.tokenize(s);
		for (String str : tokens) {
			System.out.print(str + " ");
		}
		System.out.println("");
		LispList expr = (LispList) Parsing.parse(Environment.env, tokens, 1).left;
		System.out.println(expr.getClass().getSimpleName());
		for (LispValue val : expr.list) {
			System.out.println(val.getClass().getSimpleName());
		}
		System.out.println(expr.show());
		System.out.println(expr.eval().show());
	}
}
