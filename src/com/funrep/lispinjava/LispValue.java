package com.funrep.lispinjava;

import java.util.ArrayList;

public abstract class LispValue {
	abstract LispValue eval();
	abstract String show();
	abstract LispValue apply(ArrayList<LispValue> args);
}
