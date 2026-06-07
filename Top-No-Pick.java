import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] a = new int[r][c];
        long[][] dp = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < c; j++) {
            dp[0][j] = a[0][j];
        }

        for (int i = 1; i < r; i++) {

            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;

            for (int j = 0; j < c; j++) {
                if (dp[i - 1][j] > max1) {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                    } else if (dp[i - 1][j] > max2) {
                    max2 = dp[i - 1][j];
                }
            }

            for (int j = 0; j < c; j++) {
                long best = (dp[i - 1][j] == max1) ? max2 : max1;
                dp[i][j] = a[i][j] + best;
            }
        }

        long ans = Long.MIN_VALUE;
        for (int j = 0; j < c; j++) {
            ans = Math.max(ans, dp[r - 1][j]);
        }

        System.out.println(ans);
    }
}
