package com.pereira.thermometer.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.br.pereira.thermometer.Thermometer;
import com.br.pereira.thermometer.constants.Direction;

public class ThermometerTest {

	String[] arrayOfT = { "0 C", "100 C", "95.5C", "101°C", "0C" };
	List<Integer> threashold = new ArrayList<>();
	List<Double> threashold2 = new ArrayList<>();

	PrintStream outOld = System.out;

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		threashold.add(100);
		threashold.add(0);
		
		threashold2.add(100.0);
		threashold2.add(0.0);
		

		Thermometer.initThemometer(arrayOfT);

		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAlertListOfIntegerString() {
		try {

			Thermometer.alert(threashold, "C");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains("Temperature:0.0C"));
		assertTrue(outPut.contains("Temperature:100.0C"));

	}

	@Test
	public void testAlertListOfDoubleDoubleString() {
		try {

			Thermometer.alert(threashold2,0.5, "C");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains("Temperature:0.0C"));
		assertTrue(outPut.contains("Temperature:100.0C"));
	}

	@Test
	public void testAlertListOfDoubleDirectionDoubleString() {
		try {

			Thermometer.alert(threashold2,Direction.DOWN, 0.5, "C");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains("Temperature:0.0C"));
		assertTrue(outPut.contains("Temperature:100.0C"));
	}

}
