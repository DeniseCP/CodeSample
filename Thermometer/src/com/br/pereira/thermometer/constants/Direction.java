package com.br.pereira.thermometer.constants;

public enum Direction {
	UP("UP"), DOWN("DOWN");
	
	private String value;
	
	Direction(String s){
		this.value = s;
	}
	
	public String getValue(){
		return value;
	}
	
}
