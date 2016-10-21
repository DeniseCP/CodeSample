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

	public static void alert(List<Double> list, String unit) throws Exception {
		if (!isEmpty(list)) {
			try {
				if (notEmpty(temperatures)) {
					for (Temperature temp : temperatures) {
						Temperature t = new Temperature();
						t.setTemperature(temp.convert(unit));
						t.setUnit(unit);
						if (list.contains(t.getTemperature())) {
							System.out.println(t.toString());
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

	public static void alert(List<Double> list, Double variation, String unit) {
		if (!isEmpty(list) && variation != null) {
			try {
				if (notEmpty(temperatures)) {
					for(Double i : list){
						for (Temperature temp : temperatures) {
							Temperature t = new Temperature();
							t.setTemperature(temp.convert(unit));
							t.setUnit(unit);
							if ((i+variation)!=(t.getTemperature()) 
									&& (i.equals(t.getTemperature())
											&& (i-variation!=t.getTemperature()))) {
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

	public static void alert(List<Double> list, Double varUp, Double varDown) {
		if (!isEmpty(list) && varUp != null && varDown != null) {

		}
	}

	public static void alert(List<Double> list, Direction dir) {
		if (!isEmpty(list) && dir != null) {

		}
	}

	public static void alert(List<Double> list, Double variation, Direction dir) {
		if (!isEmpty(list) && variation != null && dir != null) {

		}
	}

	public static void alert(List<Double> list, Double variationUp, Double variationDown, Direction dir) {
		if (!isEmpty(list)) {

		}
	}

	@SuppressWarnings("null")
	private static boolean isEmpty(String[] array) {
		return (array == null && array.length < 0);
	}

	@SuppressWarnings("null")
	private static boolean isEmpty(List<Double> list) {
		return (list == null && list.size() < 0);
	}

	private static boolean notEmpty(List<Temperature> list) {
		return (list != null && list.size() > 0);
	}

	public List<Temperature> getLastTemperatures() {
		return lastTemperatures;
	}

	public void setLastTemperatures(List<Temperature> lastTemperatures) {
		this.lastTemperatures = lastTemperatures;
	}

}
