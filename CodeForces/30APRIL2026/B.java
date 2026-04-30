import java.io.*;
import java.util.*;

public class B {


    static void PartyMonster(String s) {
        int open = 0, close = 0;

        // Step 1: count brackets
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else close++;
        }

        if (open != close) {
            System.out.println("NO");
            return;
        }

        // Step 2: check prefix balance
        int balance = 0;
        int negativeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;

            if (balance < 0) {
                negativeCount++;
                balance = 0; // reset (important)
            }
        }

        // Step 3: decision
        if (negativeCount > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) throws Exception{
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            PartyMonster(s);
        }


    }
}
