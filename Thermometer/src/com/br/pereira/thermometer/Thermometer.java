package com.br.pereira.thermometer;

import java.util.Map;

public class Thermometer {

	/*
	 * - Ler o array de temperaturas - verificar se F ou C - retornar se
	 * freezing or boiling
	 */

	public static String provide_temperature(String[] arrayOfT, double thresholds) {
		if (!isEmpty(arrayOfT)) {
			try {
				Map<String, Double> mapOfT = Reader.readArray(arrayOfT);

			} catch (Exception e) {
				System.out.println("Impossible to return a result. Please enter valid temperatures.");
			}
		}
		return "Impossible to return a result. Please enter valid temperatures.";

	}

	private static boolean isEmpty(String[] array) {
		return (array != null && array.length > 0);
	}
}
