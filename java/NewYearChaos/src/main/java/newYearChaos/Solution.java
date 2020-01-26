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


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            System.out.println(minimumBribes(q));
        }

        scanner.close();
    }
}