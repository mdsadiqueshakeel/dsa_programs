import java.io.*;
// import java.util.*;

public class C {

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

            while ((c = read()) <= ' ');

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

        String next() throws IOException {
            int c;

            while ((c = read()) <= ' ');

            StringBuilder sb = new StringBuilder();

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            String a = fs.next();
            String b = fs.next();

            int pref = 0;
            int mixed = 0;

            boolean ok = true;

            for (int i = 0; i < n; i++) {

                char x = a.charAt(i);
                char y = b.charAt(i);

                if (x == '(' && y == '(') {
                    pref++;
                }
                else if (x == ')' && y == ')') {
                    pref--;
                }
                else {
                    mixed++;
                }

                if (pref < 0) {
                    ok = false;
                    break;
                }

                if (pref == 0 && (mixed % 2 == 1)) {
                    ok = false;
                    break;
                }
            }

            if (pref != 0) {
                ok = false;
            }

            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }
}