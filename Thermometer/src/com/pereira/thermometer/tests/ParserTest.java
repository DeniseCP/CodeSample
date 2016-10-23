package com.pereira.thermometer.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.exception.InvalidUnitTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class ParserTest {

	String[] array = { "0 C", "100 C", "95.5C", "101°C" };
	String[] array1 = { "0 C", "100 A" };
	List<Temperature> list = null;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
	}

	@Test
	public void testParseArray() {

		list.add(new Temperature("C", 0.0));
		list.add(new Temperature("C", 100.0));
		list.add(new Temperature("C", 95.5));
		list.add(new Temperature("C", 101.0));

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseArray(array)));
		} catch (InvalidUnitTemperature e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParseArrayWrongUnit() {		
		list = new ArrayList<>();
		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseArray(array1)));
		} catch (InvalidUnitTemperature e) {
			e.printStackTrace();
		}
	}

}
