package com.pereira.thermometer.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.br.pereira.thermometer.Thermometer;
import com.br.pereira.thermometer.constants.Direction;
import com.br.pereira.thermometer.constants.Messages;

public class ThermometerTest {

	String[] arrayOfT = { "0 C", "100 C", "95.5C", "101°C", "0C" };
	List<Integer> threashold = new ArrayList<>();
	List<Double> threashold2 = new ArrayList<>();
	Path srcFile = Paths.get("resources/temperatures.txt");
	Path wrongSrcFile = Paths.get("resources/temperature.txt");
	Path wrongSrcFile2 = Paths.get("resources/temperature.abc");

	Thermometer thermomether = null;

	PrintStream outOld = System.out;

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		threashold.add(100);
		threashold.add(0);

		threashold2.add(100.0);
		threashold2.add(0.0);

		thermomether = new Thermometer(arrayOfT);

		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAlertListOfIntegerString() {
		try {

			thermomether.alert(threashold, "C");

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

			thermomether.alert(threashold2, 0.5, "C");

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

			thermomether.alert(threashold2, Direction.DOWN, 0.5, "C");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains("Temperature:0.0C"));
		assertTrue(outPut.contains("Temperature:100.0C"));
	}

	@Test
	public void testThermometerPath() {
		try {
			@SuppressWarnings("unused")
			Thermometer t = new Thermometer(srcFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains(Messages.MSG_SUCCESS));
	}

	@Test
	public void testThermometerWrongPath() {
		try {
			@SuppressWarnings("unused")
			Thermometer t = new Thermometer(wrongSrcFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains(Messages.MSG_FILE_NOT_FOUND));
	}

	@Test
	public void testThermometerWrongPath2() {
		try {
			@SuppressWarnings("unused")
			Thermometer t = new Thermometer(wrongSrcFile2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setOut(outOld);

		String outPut = new String(outContent.toByteArray());

		assertTrue(outPut.contains(Messages.MSG_FILE_NOT_FOUND));
	}
}
