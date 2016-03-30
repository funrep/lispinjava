package com.funrep.lispinjava.utils;

public class Tuple<T1, T2> {
	public T1 left;
	public T2 right;
	
	public Tuple(T1 l, T2 r) {
		left = l;
		right = r;
	}
}
