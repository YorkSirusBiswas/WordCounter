package com.example.wordcounter;

public class TextMetricsCounter {

    public int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] sentences = text.split("[.!?]+");
        int count = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // space commas and dots
        String cleaned = text.replaceAll("[,.]", " ");
        String[] words = cleaned.trim().split("\\s+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        return text.length();
    }

    public int countNumbers(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d+(\\.\\d+)?");
        java.util.regex.Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}