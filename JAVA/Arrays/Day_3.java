public class Day_3 {
    
        public static void ChudGyeGuruMeme(){
                 String text1 = "CGPA achi karunga";
            String text2 = "Chud gaye guru";
            for (int i = text1.length(); i > 0; i--) {
                System.out.println(text1.substring(0, i));
            }
            for (int i = 1; i <= text2.length(); i++) {
                System.out.println(text2.substring(0, i));
            }
        }

    // Q1. Find the missing element on Array
    public static int MissingOnArray(int []arr, int n){
        int sum = (n * (n + 1))/2;   
        int arr_sum = 0;
        for( int i = 0; i < arr.length; i ++){
            arr_sum += arr[i];
        }
        int missing_element = sum - arr_sum;
        return missing_element;
    }

    // Q2. Maximum Consecutive One's
    public static int Consecutive_Ones(int arr[]){
        int count = 0;
        int Maxi = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==1){
                count++;
                Maxi = Math.max(Maxi, count);
            }
            else{
                count = 0;
            }
        }
        return Maxi;
    }

    // Q3. Find the Number that apperas once and other number twice
    public static int Apperas_once(int []arr){
        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }


    public static void main(String[] args) {

        int arr[] = {1,2,4,5};
        System.out.println(MissingOnArray(arr, 5));

        int max_arr[] = {1,1,0,1,1,1,0,1,1,1,1};
        System.out.println(Consecutive_Ones(max_arr));

        int arr2[] = {1,1,2,3,3,4,4};
        System.out.println(Apperas_once(arr2));

    }
}