import java.io.*;
import java.util.*;

class Set2_Q6{

  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    String input[] = br.readLine().split(" ");

    for(int i = 0; i < n ; i++){
      arr[i] = Integer.parseInt(input[i]);
      if(arr[i] < 0){
        System.out.println("invalid");
        return;
      } 
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 1; i < n ; i++){
      int diff = Math.abs(arr[i-1] - arr[i]);
      map.put(diff, map.getOrDefault(diff, 0)+1);
    }

    if(map.size() == n-1){      
      System.out.println("non");
    }else{
      int mostFreq = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
      System.out.println(mostFreq);
    }

  }
}