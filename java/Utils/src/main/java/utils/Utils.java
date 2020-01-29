package utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, Integer> generateAllSubStrings(String longString, int maximumLength) {
        Map<String, Integer> allSubstrings = new HashMap<>();
        int lengthOfSubstring = 1;
        while (lengthOfSubstring <= maximumLength) {
            for (int i = 0; i <= longString.length() - lengthOfSubstring; i++) {
                String substring = longString.substring(i, i + lengthOfSubstring);
                if (allSubstrings.containsKey(substring)) {
                    allSubstrings.put(substring, allSubstrings.get(substring) + 1);
                } else {
                    allSubstrings.put(substring, 1);
                }
            }
            lengthOfSubstring++;
        }
        return allSubstrings;
    }
}
