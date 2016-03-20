package com.funrep.lispinjava;

import java.util.HashMap;
import java.util.List;

public abstract class LispValue {
	abstract LispValue eval();
	abstract String show();
	abstract LispList apply(List<LispValue> args);
	abstract HashMap<String, LispValue> getEnv();
}
