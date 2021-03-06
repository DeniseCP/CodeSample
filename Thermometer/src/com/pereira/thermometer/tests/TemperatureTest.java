package com.pereira.thermometer.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;

public class TemperatureTest {
	Temperature tempC;
	Temperature tempF;

	@Before
	public void setUp() throws Exception {
		tempC = new Temperature("C", 100.0);
		tempF = new Temperature("F", 32.0);
	}

	@Test
	public void testConvertF() {
		Double d = 212.0;

		try {
			assertEquals(d, tempC.convert("F"));
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConvertC() {
		Double d = 0.0;

		try {
			assertEquals(d, tempF.convert("C"));
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConvertWrongUnit() {
		Double d = 0.0;

		try {
			assertEquals(d, tempC.convert("A"));
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}
}
