package Recursion;

import java.util.*;
class fn {
    static int sum(int n){
        if(n == 1){
            return 1;
        }
        return  n * sum(n-1);
    }
    
    static void rev(int arr[],int l ,int r){
        if(l >= r/2){
            return ;
        }
        int temp = arr[l];
        arr[l] = arr[r-l-1];
        arr[r-l-1] = temp;
        
        rev(arr, l+1, r);
    }
    
    static boolean palindrome(String name , int i , int n){
        if(i >= n/2){
            return true;
        }
        
        if(name.charAt(i) != name.charAt(n - i - 1)) return false;
        
        return palindrome(name, i+1, n);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,0,8,5};
        String name = "MADAMS";
        rev(arr,0,arr.length);
        boolean areP = palindrome(name, 0, name.length());
        System.out.println(sum(5));
        System.out.println(Arrays.toString(arr));
        System.out.println(areP);
    }
}