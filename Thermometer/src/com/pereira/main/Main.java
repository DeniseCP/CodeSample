package com.pereira.main;

import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Thermometer;
import com.br.pereira.thermometer.constants.Direction;


public class Main {

	public static void main(String[] args) throws Exception {
		String array[] = { "0 C", "100 C", "2.5 C", "100.5 C", "101°C", "0C", "99.5C" };
		List<Integer> limiar = new ArrayList<>();
		limiar.add(100);
		limiar.add(0);

		
		List<Double> threashold = new ArrayList<>();
		threashold.add(212.0);
		threashold.add(32.0);

		
		Thermometer themomether = new Thermometer(array);

		
		//Thermometer.alert(limiar, "C");
		
		//Thermometer.alert(threashold, 0.5, "C");
		
		themomether.alert(threashold, Direction.UP, 0.9, "F");
		
		/*List<Temperature>list = new ArrayList<>();
		list.add(new Temperature("C", 0.0));
		list.add(new Temperature("C", 100.0));
		list.add(new Temperature("C", 95.5));
		list.add(new Temperature("C", 101.0));
		
		String []array = { "0 C", "100 C", "95.5C", "101°C" };
		
		System.out.println(new HashSet<>(list).equals(new HashSet<>(Parser.parseArray(array))));*/

	}

}
