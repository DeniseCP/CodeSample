package com.br.pereira.thermometer.exception;

public class InvalidUnitTemperature extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "This class implements only the following temperatures units: F or C";
	}

	
}
