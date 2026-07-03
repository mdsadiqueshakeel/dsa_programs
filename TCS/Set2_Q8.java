import java.io.*;

class Set2_Q8{

  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];

    String input[] = br.readLine().split(" ");

    float sum = 0;
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(input[i]);
      sum += arr[i];
    }

    float mean = sum/n;
    float helper = 0;
    for(int i = 0; i < n; i++){
      float x = (float)(arr[i] - mean);
      helper += x * x;
    }
    float ans = helper / n;

    String rounded = String.format("%.2f",Math.sqrt(ans));

    System.out.println(rounded);

  }
}