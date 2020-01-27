package minimumSwaps2;

import java.util.HashMap;

public class Solution {

    private static HashMap<Integer, Integer> currentPositionOfValues = new HashMap<>();

    public static int minimumSwaps(int[] inputArray) {
        currentPositionOfValues.clear();
        int numberOfSwaps = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == i + 1) continue;
            int numberThatShouldGoInThisPosition = i + 1;
            int indexOfTheNumberThatShouldGoInThisPosition;

            if (!currentPositionOfValues.containsKey(numberThatShouldGoInThisPosition)) {
                indexOfTheNumberThatShouldGoInThisPosition = findNumberInTheArray(inputArray, i, numberThatShouldGoInThisPosition);
            } else {
                indexOfTheNumberThatShouldGoInThisPosition = currentPositionOfValues.get(numberThatShouldGoInThisPosition);
            }

            swap(inputArray, i, indexOfTheNumberThatShouldGoInThisPosition);
            numberOfSwaps++;

        }
        return numberOfSwaps;
    }

    private static int findNumberInTheArray(int[] inputArray, int i, int numberToFind) {
        int positionOfTheNumber = 0;
        for (int j = i; j < inputArray.length; j++) {
            if (inputArray[j] == numberToFind) {
                positionOfTheNumber = j;
                break;
            }
        }
        return positionOfTheNumber;
    }

    private static void swap(int[] inputArray, int indexA, int indexB) {
        int temporalHolder = inputArray[indexA];
        inputArray[indexA] = inputArray[indexB];
        inputArray[indexB] = temporalHolder;
        addTheNewPositionToMemory(inputArray, indexB);
    }

    private static void addTheNewPositionToMemory(int[] inputArray, int indexB) {
        currentPositionOfValues.put(inputArray[indexB], indexB);
    }
}
