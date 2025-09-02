public class selection_sort {
     

    public static void Selection_sort(int arr[]){
        for (int i = 0; i <= arr.length - 2; i ++){
            int min = i;
            for (int j =i ; j <= arr.length-1 ; j++){
                if( arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int arr[]= {13,42,52,9,4,15};
        for(int i = 0; i < arr.length-1; i++){
            System.err.print(arr[i]+ " ");
        }
        System.out.println();
        
        Selection_sort(arr);
        
 for(int i = 0; i < arr.length-1; i++){
            System.err.print(arr[i]+ " ");
        }    }
}
