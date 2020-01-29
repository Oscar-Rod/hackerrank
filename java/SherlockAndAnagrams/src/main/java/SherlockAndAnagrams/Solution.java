package SherlockAndAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int sherlockAndAnagrams(String inputString) {
        Map<String, Integer> substrings = generateAllSubStrings(inputString, inputString.length() - 1);
        Map<String, Integer> sortedSubstrings = combineAllSubstringsWithSameNumberOfLetters(substrings);
        int numberOfAnagrams = 0;
        for (String sortedString : sortedSubstrings.keySet()) {
            if (sortedSubstrings.get(sortedString) <= 1) {
                continue;
            }
            int numberOfTimesTheStringAppears = sortedSubstrings.get(sortedString);
            int numberOfAnagramsForString = combinationsOfNElementsTakenInGroupsOfX(numberOfTimesTheStringAppears, 2);
            numberOfAnagrams += numberOfAnagramsForString;
        }
        return numberOfAnagrams;

    }

    private static int combinationsOfNElementsTakenInGroupsOfX(int n, int x) {
        int aux = n - x;
        int solution = 1;
        for (int i = aux + 1; i <= n; i++){
            solution *= i;
        }
        return solution/x;
    }

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

    public static Map<String, Integer> combineAllSubstringsWithSameNumberOfLetters(Map<String, Integer> substrings) {
        Map<String, Integer> sortedSubstrings = new HashMap<>();
        for (String substring : substrings.keySet()) {
            char[] substringChars = substring.toCharArray();
            Arrays.sort(substringChars);
            String sortedSubstring = String.copyValueOf(substringChars);
            if (sortedSubstrings.containsKey(sortedSubstring)) {
                sortedSubstrings.put(sortedSubstring, sortedSubstrings.get(sortedSubstring) + substrings.get(substring));
            } else {
                sortedSubstrings.put(sortedSubstring, substrings.get(substring));
            }
        }
        return sortedSubstrings;
    }
}
