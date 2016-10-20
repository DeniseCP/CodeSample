package com.br.pereira.thermometer.utils;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Temperature;

public class Reader {

	public static List<Temperature> readArray(String[] arrayOfT) {
		List<Temperature> list = new ArrayList<>();

		try {
			System.out.println("Passing array of temperatures...");
			for (String nav : arrayOfT) {
				list.add(split(nav));
			}
			System.out.println("Temperatures parsed...");
		} catch (Exception e) {
			System.out.println("Impossible to parse. Please enter a valid array of Temperatures.");
		}
		return list;
	}

	private static Temperature split(String nav) {
		Temperature temp = new Temperature();
		if (nav != null && !nav.trim().equals("")) {
			String t = nav.replaceAll("[^\\d*\\.?\\d*]", "");
			String u = nav.replaceAll("[^A-Za-z]+", "");
			
			temp.setTemperature(new Double(t));
			temp.setUnit(u);
		}
		return temp;
	}
}
