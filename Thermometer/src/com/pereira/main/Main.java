package com.pereira.main;

import java.util.regex.Pattern;

import com.br.pereira.thermometer.Thermometer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String array[]= {"0 C","1 C","2.5 C","0.5 C","3°C","4C"};
		
	Thermometer.provide_temperature(array, 0);
		
		
	}

}
