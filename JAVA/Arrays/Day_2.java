import java.util.ArrayList;

public class Day_2 {

    // Q1. Left Rotated array by one places
    public static int[] reverseArrayByOnPlace(int arr[]){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

        return arr;
    }

    // Q2. Left Rotated array by k places (Brute)
    public static int[] reverseArrayBy_N_Places(int arr[], int k){
        int n = arr.length;
        k = k % n;

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            temp.add(arr[i]);
        }

        for( int i = k; i < n;i++){
            arr[i-k] = arr[i];
        }

        for( int i = 0; i < temp.size()-1;i++){
            arr[(n-k)+i] = temp.get(i);
        }
        return arr;
    } 
    // Q2. Left Rotated array by k places (Optimal)
    public static void reverse(int arr[], int start, int end){
        while(start <end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] Opt_reverseArrayBy_N_Places(int arr[],int  k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);

        return arr;
    }

    // Q3. Move Zero to end (Brute)
    public static int[] ZeroOnLast(int arr[]){
        int n= arr.length;
        ArrayList<Integer> temp = new ArrayList<>();    
        for(int i = 0; i<n; i++){
            if(arr[i]!= 0){
                temp.add(arr[i]);
            }
        }

        for(int i = 0; i < temp.size(); i++){
            arr[i] = temp.get(i);
        }

        for(int i = temp.size(); i < n; i++){
            arr[i] = 0;
        }
        return arr;
    }

    // Q3. Move Zero to end (Optimal)
    public static int[] Opt_ZeroOnLast(int arr[]){
        int n = arr.length;
        int j = -1;
        for(int i = 0; i < n; i++ ){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if (j == -1) return arr;

        for(int i = j; i < n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }

        return arr;
    }

    // Q4. Linear_Search
    public static int Linear_Search(int arr[],int k){
        for(int i = 0; i < arr.length;i++){
            if(arr[i]==k){
                return i;
            }
        }
        return -1;
    }

    // Q5. Union on two sorted Array
    public static ArrayList<Integer> Union(int arr1[], int arr2[]){
        ArrayList<Integer> temp = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
         
        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                if(temp.size() == 0 || temp.get(temp.size()-1)!= arr1[i]){
                    temp.add(arr1[i]);
                }
                i++;
            }else{
                if(temp.size() == 0 || temp.get(temp.size()-1)!= arr2[j]){
                    temp.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < n1){
            if(temp.size() == 0 || temp.get(temp.size()-1)!= arr1[i]){
                temp.add(arr1[i]);
            }
            i++;
        }
        while(j < n2){
            if(temp.size() == 0 || temp.get(temp.size()-1)!= arr2[j]){
                temp.add(arr2[j]);
            }
            j++;
        }
        return temp;
    }

    //Q6. Intersection on two Sorted Array
    public static ArrayList<Integer> Intersection(int arr1[],int arr2[]){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr1[i]< arr2[j]){
                j++;
            }
            else{
                temp.add(arr1[i]);
                i++;
                j++;
            }
        }
        return temp;

    }

    public static void print(int arr[]){
      for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println((Linear_Search(arr, 5)));
        int zero_arr[]= {1,0,2,3,4,0,0,9,11,9,21};
        print(Opt_reverseArrayBy_N_Places(arr,5));
        print(reverseArrayByOnPlace(arr));
        print(Opt_ZeroOnLast(zero_arr));


        int arr1[] = {1,2,3,3,4,5,6};
        int arr2[] = {2,3,4,5,6,6,7};

        System.out.println(Union(arr1, arr2));
        System.out.println(Intersection(arr1,arr2));
        
        
    }
}
