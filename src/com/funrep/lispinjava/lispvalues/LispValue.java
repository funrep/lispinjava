package com.funrep.lispinjava.lispvalues;

import java.util.HashMap;
import java.util.List;

public abstract class LispValue {
	public abstract LispValue eval();
	public abstract String show();
	abstract LispList apply(List<LispValue> args);
	public abstract HashMap<String, LispValue> getEnv();
}
