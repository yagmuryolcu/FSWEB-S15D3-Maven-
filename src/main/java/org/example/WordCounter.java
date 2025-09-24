package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String, Integer> calculatedWord(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase().replaceAll("^[^a-zA-Z0-9çğıöşüİĞÖŞÜ]+|[^a-zA-Z0-9çğıöşüİĞÖŞÜ]+$", "");

            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
    public static Map<String, Integer> calculatedWord() {
        String text = "which turkish mustafa kemal which turkish mustafa kemal which mustafa kemal";
        return calculatedWord(text);
    }
}