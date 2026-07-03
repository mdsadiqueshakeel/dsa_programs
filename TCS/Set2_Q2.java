import java.io.*;

class Set2_Q2{

  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String size[] = br.readLine().split(" ");

    int m = Integer.parseInt(size[0]);
    int n = Integer.parseInt(size[1]);

    int ans = Integer.MAX_VALUE;

    if(m <= 0 || n <= 0){
      System.out.println("invalid input");
      return;
    }

    for(int i = 0; i < m; i++){
      String input[] = br.readLine().split(" ");
      for(int j = 0; j < n; j++){
        int a = Integer.parseInt(input[j]);
        ans = Math.min(ans, a);
      }
    }
    if(ans != Integer.MAX_VALUE){

    System.out.println(ans);
    }

  }
}