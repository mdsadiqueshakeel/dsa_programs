public import java.io.*;
import java.util.*;

public class D {

    static void Palindromex(int arr[], int n){
                    // store positions
            List<Integer>[] pos = new ArrayList[n];
            for (int i = 0; i < n; i++) pos[i] = new ArrayList<>();

            for (int i = 0; i < 2 * n; i++) {
                pos[a[i]].add(i);
            }

            int l = Integer.MAX_VALUE;
            int r = -1;

            int mex = 0;

            for (int x = 0; x < n; x++) {
                int p1 = pos[x].get(0);
                int p2 = pos[x].get(1);

                l = Math.min(l, Math.min(p1, p2));
                r = Math.max(r, Math.max(p1, p2));

                // check if segment length matches expected
                if (r - l + 1 != 2 * (x + 1)) {
                    break;
                }

                mex = x + 1;
            }

            System.out.println(mex);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[2 * n];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < 2 * n; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            // store positions
            List<Integer>[] pos = new ArrayList[n];
            for (int i = 0; i < n; i++) pos[i] = new ArrayList<>();

            for (int i = 0; i < 2 * n; i++) {
                pos[a[i]].add(i);
            }

            int l = Integer.MAX_VALUE;
            int r = -1;

            int mex = 0;

            for (int x = 0; x < n; x++) {
                int p1 = pos[x].get(0);
                int p2 = pos[x].get(1);

                l = Math.min(l, Math.min(p1, p2));
                r = Math.max(r, Math.max(p1, p2));

                // check if segment length matches expected
                if (r - l + 1 != 2 * (x + 1)) {
                    break;
                }

                mex = x + 1;
            }

            System.out.println(mex);
            
        }
    }
}