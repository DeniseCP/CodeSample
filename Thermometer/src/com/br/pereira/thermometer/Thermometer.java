package com.br.pereira.thermometer;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.constants.Direction;
import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class Thermometer {

	private static List<Temperature> temperatures = null;
	private static List<Temperature> threasholdFound = null;

	public Thermometer(String[] arrayOfT) {
		try {
			initThemometer(arrayOfT);
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}

	private static void initThemometer(String[] arrayOfT) throws InvalidScaleTemperature {
		if (!isEmpty(arrayOfT)) {
			try {
				temperatures = Parser.parseArray(arrayOfT);
			} catch (InvalidScaleTemperature e) {
				e.getStackTrace();
			}
		}
	}

	public void alert(List<Integer> list, String scale) throws Exception {
		threasholdFound = new ArrayList<>();
		if (!isEmpty(list)) {
			try {
				if (notEmpty(temperatures)) {
					for (Temperature temp : temperatures) {
						Temperature t = new Temperature();
						t.setUnit(temp.convert(scale));
						t.setScale(scale);
						if (list.contains(t.getUnit().intValue())) {
							threasholdFound.add(t);
						}
					}
				}
				if (threasholdFound.size() <= 0) {
					System.out.println(Messages.MSG_NO_RECORD_FOUND);
				} else {
					output(threasholdFound);
				}
			} catch (InvalidScaleTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		} else {
			System.out.println(Messages.MSG_NO_RECORD_FOUND);
		}
	}

	public void alert(List<Double> list, Double variation, String scale) {
		threasholdFound = new ArrayList<>();
		if (!isListEmpty(list) && variation != null) {
			try {
				if (notEmpty(temperatures)) {
					for (Double i : list) {
						for (Temperature temp : temperatures) {
							Temperature t = new Temperature();
							t.setUnit(temp.convert(scale));
							t.setScale(scale);
							if ((i + variation) != (t.getUnit())
									&& (i.equals(t.getUnit()) && (i - variation != t.getUnit()))) {
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
			} catch (InvalidScaleTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		} else {
			System.out.println(Messages.MSG_NO_RECORD_FOUND);
		}
	}

	public void alert(List<Double> list, Direction dir, Double variation, String scale) throws InvalidScaleTemperature {
		if (!isListEmpty(list) && dir != null) {
			threasholdFound = new ArrayList<>();

			try {
				for (Double i : list) {
					for (Temperature temp : temperatures) {
						Temperature t = new Temperature();
						t.setUnit(temp.convert(scale));
						t.setScale(scale);
						switch (dir.getValue()) {
						case "UP":
							if ((i.equals(t.getUnit()) || t.getUnit() > (i + variation))) {
								threasholdFound.add(t);

							}
							break;
						case "DOWN":
							if ((i.equals(t.getUnit()) || t.getUnit() < (i - variation))) {
								threasholdFound.add(t);

							}
						default:
							System.out.println(Messages.MSG_NO_RECORD_FOUND);
							break;
						}
					}
				}

				if (threasholdFound.size() <= 0) {
					System.out.println(Messages.MSG_NO_RECORD_FOUND);
				} else {
					output(threasholdFound);
				}

			} catch (

			InvalidScaleTemperature e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException n) {
				System.out.println(Messages.MSG_ERROR_EMPTY_TEMP);
			}
		} else

		{
			System.out.println(Messages.MSG_NO_RECORD_FOUND);
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

}
