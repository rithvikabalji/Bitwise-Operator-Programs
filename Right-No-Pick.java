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
            dp[i][0] = a[i][0];
        }

        for (int j = 1; j < c; j++) {

            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;

            for (int i = 0; i < r; i++) {
                if (dp[i][j - 1] > max1) {
                    max2 = max1;
                    max1 = dp[i][j - 1];
                } else if (dp[i][j - 1] > max2) {
                    max2 = dp[i][j - 1];
                }
            }

            for (int i = 0; i < r; i++) {
                long best = (dp[i][j - 1] == max1) ? max2 : max1;
                dp[i][j] = a[i][j] + best;
            }
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            ans = Math.max(ans, dp[i][c - 1]);
        }

        System.out.println(ans);
    }
}
