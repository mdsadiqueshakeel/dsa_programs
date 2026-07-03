import java.io.*;

class Set2_Q1{

 public static int prime(int n) {
    if(n <= 0) return -1;

    int number = 1;
    int primeCount = 0;

    while(primeCount < n){
      number++;
      boolean isPrime = true;
      if(number <= 1) isPrime = false;
      else if(number == 2) isPrime = true;
      else if(number % 2 == 0) isPrime = false;
      else{
        for(int i = 3; i*i <= number; i+=2){
          if(number % i == 0){
            isPrime = false;
            break;
          } 
        }
      }

      if(isPrime){
        primeCount++;
      }
    }

    return number;
}


  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input[] = br.readLine().split(" ");

    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);

    int ans = prime(b) + prime(a);

    System.out.println(prime(a));
    System.out.println(prime(b));
    System.out.println(ans-1);
  }
}