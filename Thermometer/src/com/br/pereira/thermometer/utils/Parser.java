package com.br.pereira.thermometer.utils;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.constants.Unit;
import com.br.pereira.thermometer.exception.InvalidUnitTemperature;

public class Parser {

	public static List<Temperature> parseArray(String[] arrayOfT) throws InvalidUnitTemperature {
		List<Temperature> list = new ArrayList<>();

		try {
			//System.out.println("Passing array of temperatures...");
			for (String nav : arrayOfT) {
				list.add(split(nav));
			}
			//System.out.println("Temperatures parsed...");
		} catch (Exception e) {
			list = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return list;
	}

	private static Temperature split(String nav) throws InvalidUnitTemperature {
		Temperature temp = new Temperature();
		if (nav != null && !nav.trim().equals("")) {
			String t = nav.replaceAll("[^\\d*\\.?\\d*]", "");
			String u = nav.replaceAll("[^A-Za-z]+", "");

			if (u.equalsIgnoreCase(Unit.F.getValue()) || u.equalsIgnoreCase(Unit.C.getValue())) {
				temp.setTemperature(new Double(t));
				temp.setUnit(u);
				return temp;
			} else {
				throw new InvalidUnitTemperature(Messages.MSG_ERROR_PARSE + t +" "+ u);
			}

		}
		return null;
	}
}
