package com.br.pereira.thermometer;

import java.util.HashMap;
import java.util.Map;

public class Reader {

	public static Map<String, Double> readArray(String[] arrayOfT) {
		Map<String, Double> map = new HashMap<>();

		try {
			System.out.println("Passing array of temperatures...");
			for (String nav : arrayOfT) {
				String[] a = split(nav);
				map.put(a[1], new Double(a[0]));
			}
			System.out.println("Temperatures parsed...");
		} catch (Exception e) {
			System.out.println("Impossible to parse. Please enter a valid array of Temperatures.");
		}
		return map;
	}

	private static String[] split(String nav) {
		String[] newArray = new String[2];
		if (nav != null && !nav.trim().equals("")) {
			newArray[1] = nav.replace("[A-z]", "");
			if (nav.contains(""))
				newArray[0] = nav.replace("[0-9]", "");
		}
		return newArray;
	}
}
