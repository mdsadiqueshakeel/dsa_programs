import java.util.*;
import java.io.*;

class q3{
  public static void main(String args[])throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int entries = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();
    double totalRevenue = 0;
    int totalItem = entries;

    while(entries-- > 0){
      String input[] = br.readLine().split(" ");

      String fruit = input[0];
      int quantity = Integer.parseInt(input[1]);
      int amount = Integer.parseInt(input[2]);

      int revenue = amount * quantity;

      totalRevenue += (double)revenue;


      map.put(fruit, map.getOrDefault(fruit, 0) + revenue);   
    }

    String mostSoldItem = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();


    double average = (double)(totalRevenue / totalItem);

    System.out.println("Most Sold Item: " + mostSoldItem);
    System.out.println("Total Revenue: "+ totalRevenue);
    System.out.println("Average Revenue Per Entry: "+ average);



  }
}