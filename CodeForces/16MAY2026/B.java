import java.io.*;

public class B {

    static long Suko(long n, long x1, long x2, long k){

        long d = Math.min(
                Math.abs(x1 - x2),
                n - Math.abs(x1 - x2)
        );

        long maxDistance = n / 2;

        long extra = Math.max(0, Math.min(k, maxDistance - d));

        return d + extra;
    }

    public static void main(String[] args)throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){

            String[] input = br.readLine().split(" ");

            long n = Long.parseLong(input[0]);
            long x1 = Long.parseLong(input[1]);
            long x2 = Long.parseLong(input[2]);
            long k = Long.parseLong(input[3]);

            System.out.println(Suko(n,x1,x2,k));
        }
    }
}