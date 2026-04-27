// Online Java Compiler
// Use this editor to write, compile and run your Java code online
package Recursion;
import java.util.*;
class fn3 {
    
    static void mergeSort(int arr[], int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low, mid, high);
    }
    
    static void merge(int arr[], int low, int mid, int high){
        int temp[] = new int[high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;
        
        while(i <= mid && j <= high){
            if(arr[i] > arr[j]){
                temp[k] = arr[j];
                j++;
            }else{
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= high){
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        for(int r = 0 ; r < temp.length; r++){
            arr[low + r] = temp[r];
        }
        
    }

     static int fn(int arr[], int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while( i < j ){
            while(arr[i] <= pivot && i <= high -1){
                i++;
            }
            while(arr[j] > pivot && j >= low-1 ){
                j--;
            }  
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    
    
    static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pivotIndex = fn(arr, low, high);
            quickSort(arr, low, pivotIndex -1);
            quickSort(arr, pivotIndex +1, high);
        }
    }
    
    
    public static void main(String[] args) {
        int arr[] = {1,4,2,4,1,17,0,5,2,8}; //Q1
        // mergeSort(arr,0,arr.length-1);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}