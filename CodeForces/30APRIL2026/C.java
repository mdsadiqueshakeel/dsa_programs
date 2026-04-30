


import java.util.*;
import java.io.*;
public class C {
    
    static void SnowFall(int n, int arr[]){
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        List<Integer> D = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(arr[i] % 3 == 0 && arr[i] % 2== 0){ //case 1
                A.add(arr[i]);

            }else if(arr[i] % 3 != 0 && arr[i] % 2== 0){ //case 2
                B.add(arr[i]);

            }else if(arr[i] % 3 == 0 && arr[i] % 2 != 0){ //case 3
                C.add(arr[i]);

            }else{ // case 4
                D.add(arr[i]);
            }
        }
        int idx = 0;

        for(int x : A) arr[idx++] = x;
        for(int x : B) arr[idx++] = x;
        for(int x : D) arr[idx++] = x;
        for(int x : C) arr[idx++] = x;  
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String[] input = br.readLine().split(" ");
            for(int i = 0;i < n; i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            SnowFall(n, arr);
            for(int i = 0;i < n; i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
