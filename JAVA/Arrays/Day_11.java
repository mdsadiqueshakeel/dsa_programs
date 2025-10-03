import java.util.ArrayList;

public class Day_11{
    public static ArrayList<Integer> Majority_Element_II(int[] arr){
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for(int num : arr){
            if(cnt1 == 0 && el2 != num){
                cnt1 = 1;
                el1 = num;
            }
            else if(cnt2 == 0 && el1 != num){
                cnt2 = 1;
                el2 = num;
            }
            else if(el1 == num){
                cnt1++;
            }
            else if(el2 == num){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        ArrayList<Integer> Answer = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        int mini = arr.length/3;
        for(int num : arr){
            if(el1 == num) cnt1++;
            if(el2 == num) cnt2++;
        }
        if(cnt1 > mini) Answer.add(el1);
        if(cnt2 > mini) Answer.add(el2);
        return Answer;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3};
        System.out.println(Majority_Element_II(arr));
    }
}