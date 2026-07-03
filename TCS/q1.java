import java.io.*;

class q1{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    
    while(t-- > 0){

      String input[] = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      long ans = 0;

      int start = a < b ? a : b;
      int end = a > b ? a : b;



      for(int i = start  ; i <= end; i++){
        ans+= 1L * i*i*i;
      }

      System.out.println(ans );

    }


  }
}
