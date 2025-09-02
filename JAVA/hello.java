
public class hello {
    public static void main(String[] args) {
        int n = 371;
        int dup = n;
        int reverse_Number = 0;
        while(n > 0){
            int ld = n % 10;
            reverse_Number= reverse_Number + (ld*ld* ld);
            n /= 10;
        }
        System.out.println(reverse_Number);
        if(dup == reverse_Number){
            System.out.println(true);
        }else{
            System.err.println(false);
        }
    }
}
