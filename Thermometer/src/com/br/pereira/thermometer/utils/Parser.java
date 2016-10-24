package com.br.pereira.thermometer.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.br.pereira.thermometer.Temperature;
import com.br.pereira.thermometer.constants.Messages;
import com.br.pereira.thermometer.constants.Scale;
import com.br.pereira.thermometer.exception.InvalidScaleTemperature;

public class Parser {

	public static List<Temperature> parseArray(String[] arrayOfT) throws InvalidScaleTemperature {
		List<Temperature> list = new ArrayList<>();

		try {
			// System.out.println("Passing array of temperatures...");
			for (String nav : arrayOfT) {
				list.add(split(nav));
			}
			// System.out.println("Temperatures parsed...");
		} catch (Exception e) {
			list = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return list;
	}

	public static List<Temperature> parseList(List<String> temp) {
		List<Temperature> list = new ArrayList<>();

		try {
			// System.out.println("Passing array of temperatures...");
			for (String nav : temp) {
				list.add(split(nav));
			}
			//System.out.println("Temperatures parsed...");
		} catch (Exception e) {
			list = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return list;
	}

	private static Temperature split(String nav) throws InvalidScaleTemperature {
		Temperature temp = new Temperature();
		if (nav != null && !nav.trim().equals("")) {
			String t = nav.replaceAll("[^-?[0-9]\\d*(\\.\\d+)?$]", "");
			String u = nav.replaceAll("[^A-Za-z]+", "");

			if (u.equalsIgnoreCase(Scale.F.getValue()) || u.equalsIgnoreCase(Scale.C.getValue())) {
				temp.setUnit(new Double(t));
				temp.setScale(u);
				return temp;
			} else {
				throw new InvalidScaleTemperature(Messages.MSG_ERROR_PARSE + t + " " + u);
			}

		}
		return null;
	}

	public static List<Temperature> parseXML(File file) throws InvalidScaleTemperature {
		List<Temperature> list = new ArrayList<>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			if (file.exists()) {
				Document doc = documentBuilder.parse(file);

				Element element = doc.getDocumentElement();

				list.addAll(getTemperatures(element));

				return list;
			}
			else{
				throw new IOException(Messages.MSG_FILE_NOT_FOUND);
			}
		} catch (Exception ex) {
			list = new ArrayList<>();
			System.out.println(ex.getMessage());
		}
		return list;
	}

	private static List<Temperature> getTemperatures(Element element) throws InvalidScaleTemperature {
		List<Temperature> list = new ArrayList<>();

		NodeList nodes = element.getElementsByTagName("temperature");
		try {
			for (int i = 0; i < nodes.getLength(); i++) {
				Element e = (Element) nodes.item(i);

				String scale = getScale(e);
				Double unit = getUnit(e);

				if (scale.equalsIgnoreCase(Scale.F.getValue()) || scale.equalsIgnoreCase(Scale.C.getValue()) && unit!=null) {
					list.add(new Temperature(scale, unit));
				} else {
					list = new ArrayList<>();
					throw new InvalidScaleTemperature(Messages.MSG_ERROR_PARSE + unit + " " + scale);
				}
			}
			//System.out.println("Parsed...");
			return list;
		} catch (Exception e) {
			list = new ArrayList<>();
			System.out.println(e.getMessage());
		}
		return list;
	}

	private static String getScale(Element element) throws InvalidScaleTemperature {
		NodeList nodes = element.getElementsByTagName("scale");
		String scale = "";
		for (int i = 0; i < nodes.getLength(); i++) {
			Element e = (Element) nodes.item(i);
			scale = e.getTextContent();
		}
		return scale;
	}

	private static Double getUnit(Element element) {
		NodeList nodes = element.getElementsByTagName("unit");
		Double unit = 0.0;
		for (int i = 0; i < nodes.getLength(); i++) {
			Element e = (Element) nodes.item(i);
			try {
				unit = Double.parseDouble(e.getTextContent());
			} catch (Exception ex) {
				unit = null;
				ex.getMessage();
			}
		}
		return unit;
	}
}
