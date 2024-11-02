package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class can retrieve a list of symptoms,
 * create a map of symptoms and the number of occurrences of each symptom,
 * sort that map alphabetically and
 * write that map to an output source
 *
 * <p>To use this class, provide implementation of ISymptomReader and ISymptomWriter through the constructor
 * then call each method you need to process data.</p>
 *
 * @author loic falda
 */
public class AnalyticsCounter {
	protected ISymptomReader reader;
	protected ISymptomWriter writer;

	/**
	 * This constructor allows you to specify the reader and writer objects.
	 *
	 * @param writer an instance of ISymptomWriter that will handle output of processed data.
	 * @param reader an instance of ISymptomReader that will handle retrieval of symptoms.
	 */
    public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieve a list of symptoms using ISymptomsReader.
	 *
	 * @return a list of symptoms.
	 */
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	/**
	 * Count occurrences of symptoms in the provided list and
	 * return a map of symptoms and their number of occurrences.
	 *
	 * @param symptoms a list of symptoms.
	 * @return a map of symptoms and their number of occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> symptomCount = new HashMap<>();
		for (String symptom: symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
		}

		return symptomCount;
	}

	/**
	 * Sorts a map of symptoms and their number of occurrences alphabetically.
	 *
	 * @param symptoms a map of symptoms and their number of occurrences.
	 * @return a sorted map ordered alphabetically.
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Write a map of symptoms and their number of occurrences to an output source.
	 *
	 * @param symptoms a map of symptoms and their number of occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
