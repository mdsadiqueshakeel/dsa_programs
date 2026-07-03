import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws Exception {

        int t = nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            int n = nextInt();
            int k = nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }

            Arrays.sort(a);

            ArrayList<Integer> comp = new ArrayList<>();

            int sz = 1;

            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] <= k) {
                    sz++;
                } else {
                    comp.add(sz);
                    sz = 1;
                }
            }

            comp.add(sz);

            int firstOdd = -1;

            for (int i = 0; i < comp.size(); i++) {
                if ((comp.get(i) & 1) == 1) {
                    firstOdd = i;
                    break;
                }
            }

            if (firstOdd == -1) {
                out.append("YES\n");
                continue;
            }

            boolean ok = true;

            for (int i = firstOdd + 1; i < comp.size(); i++) {
                if ((comp.get(i) & 1) == 1) {
                    ok = false;
                    break;
                }
            }

            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }
}