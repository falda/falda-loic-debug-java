package com.hemebiotech.analytics;

import java.util.Map;

/**
 * This interface define a method to write symptoms data.
 *
 * <p>It provides a method to record symptoms data to a chosen output source
 * without affecting other parts of the code.<p>
 *
 * <p>Classes implementing this interface should provide a writeSymptoms(Map) method.</p>
 *
 * @author loic falda
 */
public interface ISymptomWriter {
    /**
     * Write the symptoms and their occurrences to an output source.
     *
     * @param symptoms a map containing the symptoms and their number of occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
