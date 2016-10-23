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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temperature other = (Temperature) obj;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
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
