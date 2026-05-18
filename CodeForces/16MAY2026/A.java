import java.io.*;

public class A {

    static int MarisaTakout(int[] arr, int n) {
        int[] freq = new int[3];

        for (int x : arr) {
            freq[x]++;
        }

        int operations = 0;

        // Every 0 alone forms one operation
        operations += freq[0];

        // Form maximum [1,2] pairs
        int pairs = Math.min(freq[1], freq[2]);
        operations += pairs;

        // Remove used 1s and 2s
        freq[1] -= pairs;
        freq[2] -= pairs;

        // Remaining 1s -> [1,1,1]
        operations += freq[1] / 3;

        // Remaining 2s -> [2,2,2]
        operations += freq[2] / 3;

        return operations;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            String[] input = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            System.out.println(MarisaTakout(arr, n));
        }
    }
}