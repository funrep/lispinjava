package com.funrep.lispinjava.errors;

import com.funrep.lispinjava.lispvalues.LispError;

public class ArgCountError extends LispError {

	public ArgCountError() {
	    super("Argument count doesn't match the function.");
    }
}
