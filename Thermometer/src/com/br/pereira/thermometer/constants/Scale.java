package com.br.pereira.thermometer.constants;

public enum Scale {

	F("F"),C("C");
	
	private String value;
	
	Scale(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
