package com.hemebiotech.analytics;

import java.util.List;

/**
 * This interface define a method to read symptoms data and
 * return a List of symptoms.
 *
 * <p>It provides a method to read symptoms data from a chosen input source and
 * return a List of symptoms
 * without affecting other parts of the code.<p>
 *
 * <p>Classes implementing this interface should provide a GetSymptoms method.</p>
 *
 * @author loic falda
 */
public interface ISymptomReader {
	/**
	 * Read the symptoms and their occurrences from an output source and
	 * return a List of symptoms.
	 */
	List<String> GetSymptoms ();
}