package com.br.pereira.thermometer.constants;

public enum Unit {

	F("F"),C("C");
	
	private String value;
	
	Unit(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
