package com.funrep.lispinjava.errors;

import com.funrep.lispinjava.lispvalues.LispError;

public class EvalError extends LispError {

	public EvalError() {
	    super("Invalid expression.");
    }

}
