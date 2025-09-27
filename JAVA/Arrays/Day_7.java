import java.util.ArrayList;

public class Day_7 {

    // Q1. Best Time Buy & Sell Stocks (Optimal)
    public static int BuyAndSell(int[] arr){
        int buy = arr[0];
        int maxProfit =0;
        for (int i = 0; i < arr.length; i++){
            int cost = arr[i] - buy;
            buy = Math.min(arr[i], buy);
            maxProfit = Math.max(maxProfit, cost);
        }
        return maxProfit;
    }

    // Q2. Rearrange the Array by Sign (Brute)
    public static int[] Rearrange_Brute(int[] arr){
        ArrayList <Integer> pos = new ArrayList<>();
        ArrayList <Integer> neg = new ArrayList<>();
        for(int i =0; i< arr.length; i++){
            if(arr[i] > 0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }
        for(int i = 0; i < arr.length/2; i++){
            arr[i*2] = pos.get(i);
            arr[i*2+1] = neg.get(i);
        }
        return arr;
    }

    // Q2. Rearrange the Array by Sign (optimal)
    public static int[] Rearrange_Optimal(int[] arr){
        int posIndex = 0;
        int negIndex = 1;
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i]> 0){
                ans[posIndex] = arr[i];
                posIndex+=2;
            }else{  
                ans[negIndex] = arr[i];
                negIndex+=2;
            }
        }
        return ans;
    }

    // Q2. Alternative Rearrange the Array by Sign 
    public static int[] Rearrange_Alternative(int[] arr){
        ArrayList <Integer> pos = new ArrayList<>();
        ArrayList <Integer> neg = new ArrayList<>();
        for(int i =0; i< arr.length; i++){
            if(arr[i] > 0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
            }
        }
        if (neg.size()> pos.size()){
            for(int i = 0; i < pos.size(); i++){
                arr[i*2] = pos.get(i);
                arr[i*2+1] = neg.get(i);
            }
            int index = pos.size()*2;
            for(int i = pos.size(); i < neg.size();i++){
                arr[index] = neg.get(i);
                index++;
            }
        }else{
             for(int i = 0; i < neg.size(); i++){
                arr[i*2] = pos.get(i);
                arr[i*2+1] = neg.get(i);
            }
            int index = neg.size()*2;
            for(int i = neg.size(); i < pos.size();i++){
                arr[index] = pos.get(i);
                index++;
            }
        }

        return arr;
    }

    public static void print(int arr[]){
      for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int [] arr = {7,1,5,3,6,4};
        System.out.println(BuyAndSell(arr));

        int[] arr2 = {3,1,-2,-5,2,-4};
        print(Rearrange_Optimal(arr2));

        int arr3[] = {-3,1,-1,-2,-5,2,-4,3,9-8,-2};
        print(Rearrange_Alternative(arr3));
    }
}