
public class Day_9 {

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end --;
        }
    }

    public static int[][] Rotate_Array(int[][] arr){ 
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i = 0; i < arr.length; i++){
            reverse(arr[i], 0, arr.length-1);
        }
        return arr;
    }

    public static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
          }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(arr);
        print(Rotate_Array(arr));
    }
}
