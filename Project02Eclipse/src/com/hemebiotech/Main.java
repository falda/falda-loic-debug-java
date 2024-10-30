package com.hemebiotech;

import com.hemebiotech.analytics.*;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/resources/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse/resources/result.out");
        AnalyticsCounter counter = new AnalyticsCounter(writer, reader);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> symptomsCount = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptomsCount = counter.sortSymptoms(symptomsCount);
        counter.writeSymptoms(sortedSymptomsCount);
    }
}
