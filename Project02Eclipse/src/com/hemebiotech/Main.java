package com.hemebiotech;

import com.hemebiotech.analytics.*;

import java.util.List;
import java.util.Map;

/**
 * The main is the entrypoint to this application.
 *
 * <p>This class sets up and executes the entire process of reading symptom data from a source file,
 * counting occurrences of each symptom,
 * sorting them alphabetically and
 * writing the results to an output file.</p>
 *
 * @author loic falda
 */
public class Main {

    /**
     * This method perform the following tasks:
     * - Instantiate reader and writer components.
     * - Instantiate analytics counter with reader and writer as arguments.
     * - Retrieve the list of symptoms.
     * - Count occurrences of each symptom.
     * - Sort the map of symptoms and their count alphabetically.
     * - Write the map to the specified output file.
     *
     * @param args command-line arguments (not used here).
     */
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
