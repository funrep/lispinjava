package com.funrep.lispinjava;

import java.util.ArrayList;
import java.util.List;

public abstract class LispValue {
	abstract LispValue eval();
	abstract String show();
	abstract ArrayList<LispValue> apply(List<LispValue> args);
}
