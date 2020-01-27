package RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordsInMagazine = createDictionary(magazine);
        for (String word : note) {
            if (!wordsInMagazine.containsKey(word)) {
                return "No";
            } else {
                updateNumberOfTimesTheWordAppears(wordsInMagazine, word);
            }
        }
        return "Yes";
    }

    private static void updateNumberOfTimesTheWordAppears(Map<String, Integer> wordsInMagazine, String word) {
        int numberOfTimesTheWordAppears = wordsInMagazine.get(word);
        numberOfTimesTheWordAppears--;
        if (numberOfTimesTheWordAppears <= 0) {
            wordsInMagazine.remove(word);
        } else {
            wordsInMagazine.put(word, numberOfTimesTheWordAppears);
        }
    }

    private static Map<String, Integer> createDictionary(String[] magazine) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (String word : magazine) {
            if (dictionary.containsKey(word)) {
                int numberOfTimesTheWordAppears = dictionary.get(word);
                numberOfTimesTheWordAppears++;
                dictionary.put(word, numberOfTimesTheWordAppears);
            } else {
                dictionary.put(word, 1);
            }
        }
        return dictionary;
    }
}