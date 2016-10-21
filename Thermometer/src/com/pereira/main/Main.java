package com.pereira.main;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Thermometer;

public class Main {

	public static void main(String[] args) throws Exception {
		String array[] = { "0 C", "100 S", "2.5 C", "100.5 C", "101°C", "4C" };
		List<Integer> limiar = new ArrayList<>();
		limiar.add(212);
		limiar.add(32);

		Thermometer.initThemometer(array);

		Thermometer.alert(limiar, "F");

	}

}
