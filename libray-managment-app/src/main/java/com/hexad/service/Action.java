package com.hexad.service;

public enum Action {
	BORROW(-1),SUBMIT(1);

	private int value;
	
	Action(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}


}
