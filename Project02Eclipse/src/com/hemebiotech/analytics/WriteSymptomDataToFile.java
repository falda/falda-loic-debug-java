package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

/**
 * This class is an implementation of ISymptomWriter.
 * It can receive a map of symptoms and their number of occurrences and
 * write them in a new file.
 *
 * @author loic falda
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
    private final String filepath;

    /**
     * This constructor allows to set a file path for the file it will write.
     *
     * @param filepath the file path of the new file
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Receive a map of symptoms and their number of occurrences and
     * if file path is not null write a new file with those data at the new file path decided.
     *
     * @param symptoms the map of symptoms and their number of occurrences
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try {
                FileWriter fileWriter = new FileWriter (filepath, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
