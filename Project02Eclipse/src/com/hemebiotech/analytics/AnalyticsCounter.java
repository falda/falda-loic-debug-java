package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	protected ISymptomReader reader;
	protected ISymptomWriter writer;

    public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> symptonCount = new HashMap<>();
		for (String sympton: symptoms) {
			symptonCount.put(sympton, symptonCount.getOrDefault(sympton, 0) + 1);
		}

		return symptonCount;
	}

	public Map<String, Integer> sortSymptons(Map<String, Integer> symptons) {
		return new TreeMap<>(symptons);
	}

	public void writeSymptons(Map<String, Integer> symptons) {
		writer.writeSymptoms(symptons);
	}
}
