package com.br.pereira.thermometer;

import com.br.pereira.thermometer.constants.Scale;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;

public class Temperature {

	private String scale;
	private Double unit;

	public Temperature() {
	}

	public Temperature(String scale, Double unit) {
		this.scale = scale;
		this.unit = unit;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public Double getUnit() {
		return unit;
	}

	public void setUnit(Double unit) {
		this.unit = unit;
	}

	public String toString() {
		return "Temperature:" + unit + scale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
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
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		return true;
	}

	public Double convert(String scale) throws InvalidScaleTemperature {
		try {
			if (scale.equals(Scale.F.getValue()) && !this.scale.equals(scale)) {
				return convertToFahenheit();
			} else if (scale.equals(Scale.C.getValue()) && !this.scale.equals(scale)) {
				return convertToCelsius();
			} else if (!scale.equals(Scale.C.getValue()) && !this.scale.equals(scale) && !scale.equals(Scale.F.getValue())) {
				throw new InvalidScaleTemperature();
			}
		} catch (Exception e) {
			return unit = new Double(0.0);
		}
		return unit;
	}

	private Double convertToCelsius() {
		return ((unit - 32) / 1.8);
	}

	private Double convertToFahenheit() {
		return ((unit * 1.8) + 32);
	}
}
