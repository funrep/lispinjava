package com.funrep.lispinjava;

import java.util.List;

public abstract class LispValue {
	abstract LispValue eval();
	abstract String show();
	abstract LispValue apply(List<LispValue> args);
}
