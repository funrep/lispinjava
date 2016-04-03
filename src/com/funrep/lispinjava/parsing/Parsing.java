package com.funrep.lispinjava.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.funrep.lispinjava.lispvalues.*;
import com.funrep.lispinjava.utils.Tuple;

public class Parsing {
	public static LispValue magic(HashMap<String, LispValue> env, String s) {
		return parse(env, tokenize(s), 1).left;
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

	public static Tuple<LispValue, Integer> parse(HashMap<String, LispValue> env,
			List<String> tokens, int startPos) {
		if (tokens.size() == 0) {
			throw new Error("Empty string passed to AST.parse");
		}
		int num = 0;
		if (tokens.get(0).equals("(")) {
			LispList expr = new LispList(env);
			int i = startPos;
			boolean lambdaFlag = false;
			Tuple<LispValue, Integer> result;
			while ((!tokens.get(i).equals(")") && (i < tokens.size()))) {
				switch (tokens.get(i)) {
				case "true":
					expr.list.add(new LispBool(env, true));
					break;
				case "false":
					expr.list.add(new LispBool(env, false));
					break;
				case "nil":
					expr.list.add(new LispNil(env));
					break;
				case "lambda":
					num += 7; // lambda's symbol and parentheses tokens
					List<String> subTokens = tokens.subList(i + 1, tokens.size());
					result = parse(env, subTokens, 1);
					LispList symbols = (LispList) result.left;
					num += result.right;
					LispLambda lambda = new LispLambda(env, new ArrayList<String>(), new LispList(env));
					for (LispValue s : symbols.list) {
						if (s instanceof LispSymbol) {
							lambda.params.add(((LispSymbol) s).symbol);
						} else {
							System.out.println("Lambda param error");
						}
					}
					int endOfParams = -1;
					for (int j = i + 1; j < tokens.size(); j++) {
						if (tokens.get(j).equals(")")) {
							endOfParams = j;
							break;
						}
					}
					List<String> subTokens2 = tokens.subList(endOfParams + 1, tokens.size());
					result = parse(env, subTokens2, 1);
					lambda.body = (LispList) result.left;
					num += result.right;
					i = result.right;
					expr.list.add(lambda);
					lambdaFlag = true;
					break;
				default:
					if (tokens.get(i).charAt(0) == '"') {
						expr.list.add(new LispString(env, tokens.get(i).replaceAll("\"", "")));
						break;
					} else if (isNumber(tokens.get(i).charAt(0))) {
						expr.list.add(new LispNumber(env, Double.parseDouble(tokens.get(i))));
						break;
					} else if (tokens.get(i).equals("(")) {
						result = parse(env, tokens.subList(i, tokens.size()), 1);
						expr.list.add(result.left);
						i = result.right;
						break;
					} else {
						expr.list.add(new LispSymbol(env, tokens.get(i)));
						break;
					}
				}
				i++;
				if (lambdaFlag) {
					break;
				}
				num += 1;
			}
			// System.out.println(expr.show() + " " + num);
			return new Tuple<LispValue, Integer>(expr, num);
		} else if (tokens.size() == 1) {
			LispValue val;
			switch (tokens.get(0)) {
			case "true":
				val = new LispBool(env, true);
				break;
			case "false":
				val = new LispBool(env, false);
				break;
			case "nil":
				val = new LispNil(env);
				break;
			default:
				if (tokens.get(0).charAt(0) == '"') {
					val = new LispString(env, tokens.get(0).replaceAll("\"", ""));
					break;
				} else if (isNumber(tokens.get(0).charAt(0))) {
					val = new LispNumber(env, Double.parseDouble(tokens.get(0)));
					break;
				} else {
					val = new LispSymbol(env, tokens.get(0));
					break;
				}
			}
			return new Tuple<LispValue, Integer>(val, 1);
		}
		System.out.println("null in Parsing.parse()");
		return null;
	}
	private static boolean isNumber(char c) {
		if ((48 <= c) && (c <= 57)) {
			return true;
		}
		return false;
	}
}
