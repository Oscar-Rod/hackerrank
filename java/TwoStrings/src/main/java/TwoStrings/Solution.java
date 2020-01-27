package TwoStrings;

import java.util.*;

public class Solution {
    public static String twoStrings(String stringA, String stringB) {
        String shortString;
        String longString;
        if (stringA.length() > stringB.length()) {
            shortString = stringB;
            longString = stringA;
        } else {
            shortString = stringA;
            longString = stringB;
        }

        Set<String> allSubstringsFromLongString = generateAllSubStrings(longString, 1);
        Set<String> allSubstringsFromShortString = generateAllSubStrings(shortString, 1);
        for (String subString: allSubstringsFromShortString){
            if (allSubstringsFromLongString.contains(subString)){
                return "YES";
            }
        }
        return "NO";
    }

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
