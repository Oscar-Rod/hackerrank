package newYearChaos;

import java.util.Scanner;

public class Solution {

    // Complete the minimumBribes function below.
    public static String minimumBribes(int[] inputArray) {

        int numberOfBribes = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int numberOfPositionsItHasMovedForward = inputArray[i] - (i + 1);
            if (numberOfPositionsItHasMovedForward > 2) {
                return "Too chaotic";
            }

            int initialPositionMinusOne = Math.max(inputArray[i] - 2, 0);
            int currentPosition = i;

            for (int j = initialPositionMinusOne; j <= currentPosition; j++) {
                if (inputArray[j] > inputArray[i]) {
                    numberOfBribes++;
                }

            }
        }
        return String.valueOf(numberOfBribes);
    }
}