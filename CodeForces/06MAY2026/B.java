import java.io.*;
import java.util.*;

public class B {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] a = new int[n];

            HashMap<Integer, Integer> freq = new HashMap<>();

            int mx = 0;

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();

                mx = Math.max(mx, a[i]);

                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }

            ArrayList<Integer> order = new ArrayList<>();

            // put one maximum first
            order.add(mx);
            freq.put(mx, freq.get(mx) - 1);

            // place 0,1,2,... in order
            int cur = 0;

            while (freq.getOrDefault(cur, 0) > 0) {
                order.add(cur);
                freq.put(cur, freq.get(cur) - 1);
                cur++;
            }

            // remaining elements
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {

                int val = e.getKey();
                int cnt = e.getValue();

                while (cnt-- > 0) {
                    order.add(val);
                }
            }

            long ans = 0;

            HashSet<Integer> seen = new HashSet<>();

            int mex = 0;
            int currentMax = 0;

            for (int x : order) {

                seen.add(x);

                currentMax = Math.max(currentMax, x);

                while (seen.contains(mex)) {
                    mex++;
                }

                ans += (long) mex + currentMax;
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}