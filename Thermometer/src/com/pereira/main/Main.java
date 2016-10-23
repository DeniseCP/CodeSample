package com.pereira.main;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.br.pereira.thermometer.Thermometer;

public class Main {

	public static void main(String[] args) throws Exception {

		List<Integer> list = new ArrayList<>();

<<<<<<< HEAD
		list.add(0);
=======
		
		Thermometer themomether = new Thermometer(array);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		List<Double> list2 = new ArrayList<>();
		list2.add(1.0);
=======
		
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
>>>>>>> refs/remotes/origin/master

		Thermometer thermomether = new Thermometer(Paths.get("resources/temperatures.xml"));
		// thermomether.alert(list, "C");

		// thermomether.alert(list2, 0.5, "C");
	}

}
