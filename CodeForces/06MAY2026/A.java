import java.io.*;

public class A {

    static int Zhily(int n, int arr[]) {

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] + arr[i + 1] > 0) {
                arr[i] = arr[i] + arr[i + 1];
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int arr[] = new int[n];

            String input[] = br.readLine().split(" ");

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            System.out.println(Zhily(n, arr));
        }
    }
}