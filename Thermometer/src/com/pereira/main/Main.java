package com.pereira.main;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Thermometer;

public class Main {

	public static void main(String[] args) throws Exception {
		String array[] = { "0 C", "100 C", "2.5 C", "100.5 C", "100°C", "0C", "99.5C" };
		List<Integer> limiar = new ArrayList<>();
		limiar.add(100);
		limiar.add(0);

		
		List<Double> threashold = new ArrayList<>();
		threashold.add(100.0);
		threashold.add(0.0);

		
		Thermometer.initThemometer(array);

		//Thermometer.alert(limiar, "C");
		
		//Thermometer.alert(threashold, 0.5, "C");
		
		

	}

}
