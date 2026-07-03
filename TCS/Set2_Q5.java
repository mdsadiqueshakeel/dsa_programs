import java.io.*;

class Set2_Q5{

  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    double result = Math.pow(2,n);
    System.out.println((int)result - 1);
  }
}