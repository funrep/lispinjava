package com.funrep.lispinjava;

public class Tuple<T1, T2> {
	public T1 right;
	public T2 left;
	
	public Tuple(T1 r, T2 l) {
		right = r;
		left = l;
	}
}
