package Sliding_Window;

import java.util.HashMap;

public class Medium {
    // longest substring with k distinct characters
    public static int Longest_K_distinct(String str, int k){
        int left = 0;
        int right = 0;
        int maxlen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right < str.length()){
            map.put(str.charAt(right),map.getOrDefault(str.charAt(right), 0)+1);
            if(map.size()>k){
                map.put(str.charAt(left),map.get(str.charAt(left))-1);
                if(map.get(str.charAt(left))==0){
                    map.remove(str.charAt(left));
                    left++;
                }
            }
            if(map.size()<=k){
                maxlen = Math.max(maxlen,right-left+1);
            }
            right++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String name = "aaabbccdd";
        System.out.println(Longest_K_distinct(name, 3));

    }
}
