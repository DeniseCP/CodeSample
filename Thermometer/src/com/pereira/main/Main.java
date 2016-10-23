package com.pereira.main;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Thermometer;

public class Main {

	public static void main(String[] args) throws Exception {

		List<Integer> list = new ArrayList<>();

		list.add(0);

		List<Double> list2 = new ArrayList<>();
		list2.add(1.0);

		Thermometer thermomether = new Thermometer(Paths.get("resources/temperatures.xml"));
		// thermomether.alert(list, "C");

		// thermomether.alert(list2, 0.5, "C");
	}

}
