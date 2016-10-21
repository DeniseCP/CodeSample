package com.br.pereira.thermometer;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.exception.InvalidUnitTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class Thermometer {

	private static List<Temperature> temperatures = null;
	private List<Temperature> lastTemperatures = new ArrayList<>();

	enum Direction {
		UP, DOWN
	};

	public static void initThemometer(String[] arrayOfT) throws InvalidUnitTemperature {
		if (!isEmpty(arrayOfT)) {
			try {
				temperatures = Parser.parseArray(arrayOfT);
			} catch (InvalidUnitTemperature e) {
				System.out.println("Impossible to return a result. Please enter valid temperatures.");
			}
		}
	}

	public static void alert(List<Integer> list, String unit) throws Exception {
		if (!isEmpty(list)) {
			try {
				for (int i = 0; i < list.size(); i++) {
					if (!isListEmpty(temperatures)) {
						for (Temperature temp : temperatures) {
							Temperature t = new Temperature();
							t.setTemperature(temp.convert(unit));
							t.setUnit(unit);
							if (list.contains(t.getTemperature().intValue())) {
								System.out.println(t.toString());
							}
						}
					}
				}
			} catch (InvalidUnitTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		}
	}

	public static void alert(List<Integer> list, Double variation) {
		if (!isEmpty(list) && variation != null) {
			list.addAll(list);
		}
	}

	public static void alert(List<Integer> list, Double varUp, Double varDown) {
		if (!isEmpty(list) && varUp != null && varDown != null) {
			list.addAll(list);
		}
	}

	public static void alert(List<Integer> list, Direction dir) {
		if (!isEmpty(list) && dir != null) {
			list.addAll(list);
		}
	}

	public static void alert(List<Integer> list, Double variation, Direction dir) {
		if (!isEmpty(list) && variation != null && dir != null) {
			list.addAll(list);
		}
	}

	public static void alert(List<Integer> list, Double variationUp, Double variationDown, Direction dir) {
		if (!isEmpty(list)) {
			list.addAll(list);
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

	private static boolean isListEmpty(List<Temperature> list) {
		return (list != null && list.size() > 0);
	}

	public List<Temperature> getLastTemperatures() {
		return lastTemperatures;
	}

	public void setLastTemperatures(List<Temperature> lastTemperatures) {
		this.lastTemperatures = lastTemperatures;
	}

}
