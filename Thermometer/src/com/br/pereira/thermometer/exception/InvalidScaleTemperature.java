package com.br.pereira.thermometer.exception;

public class InvalidScaleTemperature extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String string;

	public InvalidScaleTemperature(String string) {
		this.string = string;
	}

	public InvalidScaleTemperature() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return string;
	}

}
