package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of ISymptomReader.
 * It can receive a file to read and
 * return a list of symptoms from that file.
 *
 * @author loic falda
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private final String filepath;

	/**
	 * This constructor allows to set the file path of the file we want to read.
	 *
	 * @param filepath the file path of the file we are reading
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * If file path is not null: read the file at the chosen file path and
	 * return a list of symptoms from it.
	 * Else return an empty list.
	 *
	 * @return a list of symptoms
	 */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}