package com.br.pereira.thermometer;

public class Temperature {

	private String unit;
	private Double temperature;

	public Temperature(){}
	
	public Temperature(String unit, Double temperature) {
		this.unit = unit;
		this.temperature = temperature;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	public String toString(){
		return "Temperature:"+temperature+unit;
	}
	
	public Double convertToCelsius(Double t){
		return null;
	}
	
	public Double convertToFahenheit(Double t){
		return null;
	}
}
