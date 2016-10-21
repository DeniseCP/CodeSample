package com.br.pereira.thermometer;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.exception.InvalidUnitTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class Thermometer {

	private static List<Temperature> temperatures = null;
	private List<Temperature> lastTemperatures = new ArrayList<>();
	private static List<Temperature> threasholdFound = null;

	enum Direction {
		UP, DOWN
	};

	public static void initThemometer(String[] arrayOfT) throws InvalidUnitTemperature {
		if (!isEmpty(arrayOfT)) {
			try {
				temperatures = Parser.parseArray(arrayOfT);
			} catch (InvalidUnitTemperature e) {
				e.getStackTrace();
			}
		}
	}

	public static void alert(List<Integer> list, String unit) throws Exception {
		threasholdFound = new ArrayList<>();
		if (!isEmpty(list)) {
			try {
				if (notEmpty(temperatures)) {
					for (Temperature temp : temperatures) {
						Temperature t = new Temperature();
						t.setTemperature(temp.convert(unit));
						t.setUnit(unit);
						if (list.contains(t.getTemperature().intValue())) {
							threasholdFound.add(t);
						}
					}
				}
				if (threasholdFound.size() <= 0) {
					System.out.println(Messages.MSG_NO_RECORD_FOUND);
				} else {
					output(threasholdFound);
				}
			} catch (InvalidUnitTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		} else {
			System.out.println(Messages.MSG_NO_RECORD_FOUND);
		}
	}

	public static void alert(List<Double> list, Double variation, String unit) {
		threasholdFound = new ArrayList<>();
		if (!isListEmpty(list) && variation != null) {
			try {
				if (notEmpty(temperatures)) {
					for (Double i : list) {
						for (Temperature temp : temperatures) {
							Temperature t = new Temperature();
							t.setTemperature(temp.convert(unit));
							t.setUnit(unit);
							if ((i + variation) != (t.getTemperature())
									&& (i.equals(t.getTemperature()) && (i - variation != t.getTemperature()))) {
								threasholdFound.add(t);
							}
						}
					}
				}
				if (threasholdFound.size() <= 0) {
					System.out.println(Messages.MSG_NO_RECORD_FOUND);
				} else {
					output(threasholdFound);
				}
			} catch (InvalidUnitTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		} else {
			System.out.println(Messages.MSG_NO_RECORD_FOUND);
		}
	}

	public static void alert(List<Integer> list, Direction dir) {
		if (!isEmpty(list) && dir != null) {
			// TODO
		}
	}

	public static void alert(List<Integer> list, Double variation, Direction dir) {
		if (!isEmpty(list) && variation != null && dir != null) {
			// TODO
		}
	}

	private static void output(List<Temperature> threasholdFound) {
		for (Temperature t : threasholdFound) {
			System.out.println(t.toString());
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
	private static boolean isListEmpty(List<Double> list) {
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
