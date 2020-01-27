package ArrayManipulation;

public class Solution {
    public static long arrayManipulation(int sizeArray, int[][] queries) {
        long biggestValue = 0;
        long[] solutionArray = new long[sizeArray];
        for (int i = 0; i < queries.length; i++) {
            solutionArray[queries[i][0] - 1] += queries[i][2];
            if (queries[i][1] < solutionArray.length) {
                solutionArray[queries[i][1]] -= queries[i][2];
            }
        }
        long currentValue = 0;
        for (int i = 0; i < solutionArray.length; i++) {
            currentValue += solutionArray[i];
            if (currentValue > biggestValue) {
                biggestValue = currentValue;
            }
        }
        return biggestValue;
    }
}
