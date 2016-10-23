package com.br.pereira.thermometer.exception;

public class InvalidUnitTemperature extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String string;

	public InvalidUnitTemperature(String string) {
		this.string = string;
	}

	public InvalidUnitTemperature() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return string;
	}

}
