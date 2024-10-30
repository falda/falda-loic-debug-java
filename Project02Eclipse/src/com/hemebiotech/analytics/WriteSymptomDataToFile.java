package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private final String filepath;
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try {
                FileWriter fileWriter = new FileWriter (filepath, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
