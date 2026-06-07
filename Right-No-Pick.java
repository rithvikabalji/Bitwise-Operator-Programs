import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        long[][] dp = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < rows; row++) {
            dp[row][0] = matrix[row][0];
        }

        for (int col = 1; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                long bestValue = Long.MIN_VALUE;

                for (int prevRow = 0; prevRow < rows; prevRow++) {
                    if (prevRow != row) {
                        bestValue = Math.max(bestValue, dp[prevRow][col - 1]);
                    }
                }

                dp[row][col] = matrix[row][col] + bestValue;
            }
        }

        long answer = Long.MIN_VALUE;

        for (int row = 0; row < rows; row++) {
            answer = Math.max(answer, dp[row][cols - 1]);
        }

        System.out.println(answer);
    }
}
