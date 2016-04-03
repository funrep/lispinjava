package com.funrep.lispinjava.errors;

import com.funrep.lispinjava.lispvalues.LispError;

public class TypeError extends LispError {
	public TypeError() {
	    super("Wrong type of value passed to function.");
    }
}
