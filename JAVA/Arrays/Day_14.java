public class Day_14 {

   public static boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        int i = 0;
        int j = sb.length()-1;
        while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "A man, A Plan, A canal:Panama";
        System.out.println(isPalindrome(str));
    }
}