// Online Java Compiler
// Use this editor to write, compile and run your Java code online
package Recursion;
import java.util.*;

class fn4 {
    
    static void combinationSum(int idx, int sum, int target, int arr[], ArrayList<Integer> ds){
        if(idx == arr.length ){
            if(0 == target){
                System.out.println(ds);
            }
            return;
            
        }
        
        if(arr[idx] <= target){
            ds.add(arr[idx]);
            combinationSum(idx,sum, target - arr[idx], arr, ds);
            ds.remove(ds.size()-1);
        }
        
        combinationSum(idx+1, sum, target, arr, ds);
        
    }
    
    static void combinationSumII(int idx, int target , int arr[], List<Integer> ds ){
            if(0 == target){
                System.out.println(ds);
                return;
            }
    
            for(int i = idx; i < arr.length; i++){
                if(i > idx && arr[i] == arr[i-1]) continue;
                if(arr[i] > target) break;
                ds.add(arr[i]);
                combinationSumII(i+1 , target- arr[i],arr, ds);
                ds.remove(ds.size()-1);
            }
        }
        
    public static void main(String[] args) {
        int arr[] = {2,3, 6,7};
        int target = 7;
        ArrayList<Integer> ds = new ArrayList<>();
        combinationSum(0,0,target,arr,ds);
        ArrayList<Integer> dst = new ArrayList<>();
        combinationSumII(0,target,arr,dst);
    }
}