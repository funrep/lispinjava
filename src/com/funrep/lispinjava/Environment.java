package com.funrep.lispinjava;

import java.util.HashMap;

import com.funrep.lispinjava.lispvalues.LispPrimitive;
import com.funrep.lispinjava.lispvalues.LispValue;

public class Environment {
	static public HashMap<String, LispValue> env = new HashMap<String, LispValue>();
	
	static public void initEnv() {
		env.put("+", new LispPrimitive(env, "+"));
		env.put("-", new LispPrimitive(env, "-"));
		env.put("equal?", new  LispPrimitive(env, "equal?"));
		env.put("cons", new LispPrimitive(env, "cons"));
		env.put("head", new LispPrimitive(env, "head"));
		env.put("tail", new LispPrimitive(env, "tail"));
	}
}
