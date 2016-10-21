package com.br.pereira.thermometer;

import com.br.pereira.thermometer.constants.Unit;
import com.br.pereira.thermometer.exception.InvalidUnitTemperature;

public class Temperature {

	private String unit;
	private Double temperature;

	public Temperature() {
	}

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

	public String toString() {
		return "Temperature:" + temperature + unit;
	}

	public Double convert(String unit) throws InvalidUnitTemperature {

		if (unit.equals(Unit.F.getValue()) && !this.unit.equals(unit)) {
			return convertToFahenheit();
		} else if (unit.equals(Unit.C.getValue()) && !this.unit.equals(unit)) {
			return convertToCelsius();
		}else{
			return temperature;
		}
	}

	private Double convertToCelsius() {
		return((temperature - 32) / 1.8);
	}

	private Double convertToFahenheit() {
		return((temperature * 1.8) + 32);
	}
}
