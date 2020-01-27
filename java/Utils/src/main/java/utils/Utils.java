package utils;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static Set<String> generateAllSubStrings(String longString, int maximumLength) {
        Set<String> allSubstrings = new HashSet<>();
        int lengthOfSubstring = 1;
        while (lengthOfSubstring <= maximumLength) {
            for (int i = 0; i <= longString.length() - lengthOfSubstring; i++) {
                allSubstrings.add(longString.substring(i, i + lengthOfSubstring));
            }
            lengthOfSubstring++;
        }
        return allSubstrings;
    }
}
