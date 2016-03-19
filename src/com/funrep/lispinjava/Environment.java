package com.funrep.lispinjava;

import java.util.HashMap;

public class Environment {
	static public HashMap<String, LispValue> env = new HashMap<String, LispValue>();
	
	static public void initEnv() {
		env.put("+", new LispPrimitive("+"));
		env.put("-", new LispPrimitive("-"));
	}
}
