package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/resources/symptoms.txt"));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
            switch (line) {
                case "headache" -> {
                    headacheCount++;
                    System.out.println("number of headaches: " + headacheCount);
                }
                case "rash" -> rashCount++;
                case "dialated pupils" -> pupilCount++;
            }

			line = reader.readLine();
		}

		reader.close();

		FileWriter fileWriter = new FileWriter ("Project02Eclipse/resources/result.out", false);
		BufferedWriter writer = new BufferedWriter(fileWriter);

		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
