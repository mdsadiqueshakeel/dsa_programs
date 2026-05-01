
import java.util.*;
public class A {
    
    static void koshary(int a, int b){
        if(a % 2 == 1 && b % 2 == 1){
            // System.out.println("NO");
            System.out.println("NO");
        }else{
            // System.out.println("YES");
            System.out.println("YES");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            koshary(x , y);
        }
        
        sc.close();
    }
}