package com.br.pereira.thermometer.utils;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.constants.Scale;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;

public class Parser {

	public static List<Temperature> parseArray(String[] arrayOfT) throws InvalidScaleTemperature {
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

	private static Temperature split(String nav) throws InvalidScaleTemperature {
		Temperature temp = new Temperature();
		if (nav != null && !nav.trim().equals("")) {
			String t = nav.replaceAll("[^\\d*\\.?\\d*]", "");
			String u = nav.replaceAll("[^A-Za-z]+", "");

			if (u.equalsIgnoreCase(Scale.F.getValue()) || u.equalsIgnoreCase(Scale.C.getValue())) {
				temp.setUnit(new Double(t));
				temp.setScale(u);
				return temp;
			} else {
				throw new InvalidScaleTemperature(Messages.MSG_ERROR_PARSE + t +" "+ u);
			}

		}
		return null;
	}
}
