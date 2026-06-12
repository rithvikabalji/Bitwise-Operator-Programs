import java.util.*;
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
 
        int MAX = 200000;
 
        int[] diff = new int[MAX + 2];
 
        // Store ranges
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
 
            diff[l]++;
            diff[r + 1]--;
        }
 
        // Count how many recipes recommend each temperature
        int[] count = new int[MAX + 1];
 
        for (int i = 1; i <= MAX; i++) {
            count[i] = count[i - 1] + diff[i];
        }
 
        // Mark admissible temperatures
        int[] good = new int[MAX + 1];
 
        for (int i = 1; i <= MAX; i++) {
            if (count[i] >= k) {
                good[i] = 1;
            }
        }
 
        // Prefix sum of admissible temperatures
        int[] prefix = new int[MAX + 1];
 
        for (int i = 1; i <= MAX; i++) {
            prefix[i] = prefix[i - 1] + good[i];
        }
 
        // Answer queries
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
 
            System.out.println(prefix[b] - prefix[a - 1]);
        }
    }
}
