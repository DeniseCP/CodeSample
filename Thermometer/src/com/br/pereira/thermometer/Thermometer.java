package com.br.pereira.thermometer;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.utils.Reader;

public class Thermometer {

	/*
	 * - Ler o array de temperaturas - verificar se F ou C - retornar se
	 * freezing or boiling
	 */
	private static List<Temperature> temperatures = null;
	private List<Integer> threashold = new ArrayList<>();
	private List<Temperature> lastTemperatures = new ArrayList<>();
	private Double variation = null;
	private Double varUp = null;
	private Double varDown = null;

	enum Direction {
		UP, DOWN
	};

	public void initThemometer(String[] arrayOfT) {
		if (!isEmpty(arrayOfT)) {
			try {
				temperatures = Reader.readArray(arrayOfT);
			} catch (Exception e) {
				System.out.println("Impossible to return a result. Please enter valid temperatures.");
			}
		}
	}

	public Thermometer(List<Integer> list) {
		if (!isEmpty(list)) {
			threashold.addAll(list);
		}
	}

	public Thermometer(List<Integer> list, Double variation) {
		if (!isEmpty(list) && variation != null) {
			threashold.addAll(list);
			this.setVariation(variation);
		}
	}

	public Thermometer(List<Integer> list, Double varUp, Double varDown) {
		if (!isEmpty(list)&& varUp != null && varDown != null) {
			threashold.addAll(list);
			this.setVarUp(varUp);
			this.setVarDown(varDown);
		}
	}

	public Thermometer(List<Integer> value, Direction dir) {

	}

	public Thermometer(List<Integer> value, int variation, Direction dir) {

	}

	public Thermometer(List<Integer> value, int variationUp, int variationDown, Direction dir) {

	}

	public Temperature alertTemperature(String tempUnit) {
		
		
		
		return null;
	}

	public Temperature alertTemperature(List<Integer> threashold, Integer variation) {

		return null;
	}

	@SuppressWarnings("null")
	private static boolean isEmpty(String[] array) {
		return (array == null && array.length < 0);
	}
	
	@SuppressWarnings("null")
	private static boolean isEmpty(List<Integer> list) {
		return (list == null && list.size() < 0);
	}

	public List<Temperature> getLastTemperatures() {
		return lastTemperatures;
	}

	public void setLastTemperatures(List<Temperature> lastTemperatures) {
		this.lastTemperatures = lastTemperatures;
	}

	public Double getVariation() {
		return variation;
	}

	public void setVariation(Double variation) {
		this.variation = variation;
	}

	public Double getVarUp() {
		return varUp;
	}

	public void setVarUp(Double varUp) {
		this.varUp = varUp;
	}

	public Double getVarDown() {
		return varDown;
	}

	public void setVarDown(Double varDown) {
		this.varDown = varDown;
	}
}
