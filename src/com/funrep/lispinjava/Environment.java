package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.HashMap;

import com.funrep.lispinjava.lispvalues.LispLambda;
import com.funrep.lispinjava.lispvalues.LispList;
import com.funrep.lispinjava.lispvalues.LispPrimitive;
import com.funrep.lispinjava.lispvalues.LispSymbol;
import com.funrep.lispinjava.lispvalues.LispValue;

public class Environment {
	static public HashMap<String, LispValue> env = new HashMap<String, LispValue>();
	
	static public void initEnv() {
		env.put("+", new LispPrimitive(env, "+"));
		env.put("-", new LispPrimitive(env, "-"));
		LispLambda f = new LispLambda(env, new ArrayList<String>(), new LispList(env));
		f.body.list.add(new LispSymbol(env, "+"));
		f.body.list.add(new LispSymbol(env, "x"));
		f.body.list.add(new LispSymbol(env, "y"));
		f.params.add("x");
		f.params.add("y");
		env.put("f", f);
	}
}
