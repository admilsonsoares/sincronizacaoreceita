package com.sicred.sincronizacaoreceita.model;

public enum Status {
	A, I, B, P;

	public static Status statusRandom() {
		return values()[(int) (Math.random() * values().length)];
	}
}
