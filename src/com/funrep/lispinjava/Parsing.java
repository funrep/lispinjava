package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
	public static LispList magic(String s) {
		return parse(tokenize(s));
	}
	public static ArrayList<String> tokenize(String s) {
		String[] ss = s.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").split(" ");
		ArrayList<String> tokens = new ArrayList<String>();
		for (int i = 0; i < ss.length; i++) {
			boolean isWhitespace = ss[i].matches("^\\s*$");
			if (!isWhitespace) {
				tokens.add(ss[i]);
			}
		}
		return tokens;
	}

	public static LispList parse(List<String> tokens) {
		if (tokens.size() == 0) {
			throw new Error("Empty string passed to AST.parse");
		}
		
		if (tokens.get(0).equals("(")) {
			LispList expr = new LispList();
			int i = 1;
			while ((!tokens.get(i).equals(")") && (i < tokens.size()))) {
				switch (tokens.get(i)) {
				case "true":
					expr.list.add(new LispBool(true));
					break;
				case "false":
					expr.list.add(new LispBool(false));
					break;
				case "lambda":
					// do stuff
					break;
				default:
					if (tokens.get(i).charAt(0) == '"') {
						expr.list.add(new LispString(tokens.get(i).replaceAll("\"", "")));
						break;
					} else if (isNumber(tokens.get(i).charAt(0))) {
						expr.list.add(new LispNumber(Double.parseDouble(tokens.get(i))));
						break;
					} else if (tokens.get(i).equals("(")) {
						expr.list.add(parse(tokens.subList(i + 1, tokens.size())));
					} else {
						expr.list.add(new LispSymbol(tokens.get(i)));
						break;
					}
				}
				i++;
			}
			return expr;
		}
		
		return null;
	}
	
	private static boolean isNumber(char c) {
		if ((48 <= c) && (c <= 57)) {
			return true;
		}
		return false;
	}
}
