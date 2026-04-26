// Online Java Compiler
// Use this editor to write, compile and run your Java code online

package Recursion;

import java.util.*;
class fn2 {
    
    static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    
    static void subSeq(int idx , ArrayList<Integer> arr, int num[]){
        if(idx == num.length){
            System.out.println(arr);
            return;
        }
        arr.add(num[idx]);
        subSeq(idx+1, arr, num);
        arr.remove(arr.size()-1);
        subSeq(idx+1, arr, num);
    }
    
    //Subseq with sum of k 
    static void subSeqSumK(int idx,ArrayList<Integer> ds ,int s,int arr[],int k){
        if(idx == arr.length){
            if(s == k){
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[idx]);
        s+=arr[idx];
        subSeqSumK(idx + 1, ds, s,arr, k);
        ds.remove(ds.size()-1);
        s-=arr[idx];
        
        subSeqSumK(idx+1, ds, s, arr, k);
    }

    public static void main(String[] args) {
        System.out.println(fib(11));  // Q1
        
        System.out.println("-------------------------------------");
        
        int num[] = {3, 1, 2}; // Q2
        ArrayList<Integer> ds = new ArrayList<>();
        subSeq(0,ds, num);
        
        System.out.println("-------------------------------------");
        
        int arr[] = {1,2,1}; // Q3
        int sum = 2;
        subSeqSumK(0, ds, 0, arr, sum);
        
    }
}