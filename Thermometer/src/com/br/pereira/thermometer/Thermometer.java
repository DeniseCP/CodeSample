package com.br.pereira.thermometer;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.exception.InvalidUnitTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class Thermometer {

	private static List<Temperature> temperatures = null;
	private static List<Integer> threashold = new ArrayList<>();
	private List<Temperature> lastTemperatures = new ArrayList<>();

	enum Direction {
		UP, DOWN
	};

	public static void initThemometer(String[] arrayOfT) {
		if (!isEmpty(arrayOfT)) {
			try {
				temperatures = Parser.parseArray(arrayOfT);
			} catch (Exception e) {
				System.out.println("Impossible to return a result. Please enter valid temperatures.");
			}
		}
	}

	public static void alert(List<Integer> list, String unit) {
		if (!isEmpty(list)) {
			threashold.addAll(list);
			for (int i = 0; i < threashold.size(); i++) {
				if (!isListEmpty(temperatures)) {
					for (Temperature temp : temperatures) {
						try {
							Temperature t = new Temperature();
							t.setTemperature(temp.convert(unit));
							t.setUnit(unit);
							if (threashold.contains(t.getTemperature().intValue())) {
								System.out.println(t.toString());
							}
						} catch (InvalidUnitTemperature e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void alert(List<Integer> list, Double variation) {
		if (!isEmpty(list) && variation != null) {
			threashold.addAll(list);

		}
	}

	public Thermometer(List<Integer> list, Double varUp, Double varDown) {
		if (!isEmpty(list) && varUp != null && varDown != null) {
			threashold.addAll(list);

		}
	}

	public Thermometer(List<Integer> list, Direction dir) {
		if (!isEmpty(list) && dir != null) {
			threashold.addAll(list);

		}
	}

	public Thermometer(List<Integer> list, Double variation, Direction dir) {
		if (!isEmpty(list) && variation != null && dir != null) {
			threashold.addAll(list);

		}
	}

	public Thermometer(List<Integer> list, Double variationUp, Double variationDown, Direction dir) {

		if (!isEmpty(list)) {
			threashold.addAll(list);

		}
	}

	@SuppressWarnings("null")
	private static boolean isEmpty(String[] array) {
		return (array == null && array.length < 0);
	}

	@SuppressWarnings("null")
	private static boolean isEmpty(List<Integer> list) {
		return (list == null && list.size() < 0);
	}

	@SuppressWarnings("null")
	private static boolean isListEmpty(List<Temperature> list) {
		return (list == null && list.size() < 0);
	}

	public List<Temperature> getLastTemperatures() {
		return lastTemperatures;
	}

	public void setLastTemperatures(List<Temperature> lastTemperatures) {
		this.lastTemperatures = lastTemperatures;
	}

}
