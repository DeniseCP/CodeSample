package com.pereira.thermometer.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;
import com.br.pereira.thermometer.utils.Parser;

public class ParserTest {

	String[] array = { "0 C", "100 C", "95.5C", "101°C" };
	String[] array1 = { "0 C", "100 A" };
	Path xmlSrc = Paths.get("resources/temperatures.xml");
	Path srcWrongPath = Paths.get("resources/temperature.xml");
	Path xmlSrcWrongScale = Paths.get("resources/temperaturesWrong.xml");
	Path xmlSrcWrongUnit = Paths.get("resources/temperaturesWrongUnit.xml");
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
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParseArrayWrongUnit() {
		list = new ArrayList<>();
		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseArray(array1)));
		} catch (InvalidScaleTemperature e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParserList() {
		List<String> strList = new ArrayList<>();
		strList.add("0C");
		strList.add("-5C");
		strList.add("0.5 C");
		strList.add("-5 C");

		list.add(new Temperature("C", 0.0));
		list.add(new Temperature("C", -5.0));
		list.add(new Temperature("C", 0.5));
		list.add(new Temperature("C", -5.0));

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseList(strList)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParserListWrong() {
		List<String> strList = new ArrayList<>();
		strList.add("0A");
		strList.add("-5C");
		strList.add("0.5 C");
		strList.add("-5 C");

		list = new ArrayList<>();

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseList(strList)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testParserXml() {
		File f = new File(xmlSrc.toString());

		list.add(new Temperature("C", 0.0));
		list.add(new Temperature("C", 0.5));
		list.add(new Temperature("C", 0.0));

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseXML(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParserXmlWrongSrc() {
		File f = new File(srcWrongPath.toString());

		list = new ArrayList<>();

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseXML(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParserXmlWrongScale() {
		File f = new File(xmlSrcWrongScale.toString());

		list = new ArrayList<>();

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseXML(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParserXmlWrongUnit() {
		File f = new File(xmlSrcWrongUnit.toString());

		list = new ArrayList<>();

		try {
			assertEquals(new HashSet<>(list), new HashSet<>(Parser.parseXML(f)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
