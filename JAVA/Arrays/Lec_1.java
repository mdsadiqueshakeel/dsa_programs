import java.util.ArrayList;

public class Lec_1 {
    
// Largest element in Array without sort
    public static int Largest_element(int arr[]){
        int largest = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }
        return largest;
    }

// Second Largest element in Array without Sort
    public static int second_largest(int arr[]){
        int largest = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }

        int s_largest = Integer.MIN_VALUE;
        for(int j = 0; j < arr.length; j++ ){
            if(arr[j] != largest && s_largest < arr[j]){
                s_largest = arr[j];
            }
        }

        return s_largest;
    }

// Check the Array is Sorted
    public static boolean isSorted(int arr[]){
        for(int i = 1; i < arr.length; i ++){
            if ( arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }

// Remove the duplicates in place of sorted array
    public static int remove_dupliactes(int arr[]){
        int idx = 0;
        ArrayList <Integer> s_arr = new ArrayList<>();
        s_arr.add(arr[idx]);
        for(int i = 1; i < arr.length; i++){
            if(arr[idx] != arr[i]){
                arr[idx+1] = arr[i];
                idx++;
                s_arr.add(arr[idx]);
            }
        }
        System.out.println(s_arr);
        return idx+1;
    } 

    public static void main(String[] args) {
        int arr[]= {2,10,1,3,8,7,5,4};
        int s_arr[] = {3,4,7,9,9,9,9,11,11,11};
        int Largest_number = Largest_element(arr);
        int SecondLargest = second_largest(arr);
        System.out.println(Largest_number);

        System.out.println(SecondLargest);

        System.out.println(isSorted(s_arr));

        System.out.println(remove_dupliactes(s_arr));
    }
}
