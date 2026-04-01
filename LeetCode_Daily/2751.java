// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int positions[] = {1, 4, 2, 7, 5, 9, 3};
        int healths[] = {5, 3, 8, 6, 2, 7, 4};
        String directions = "RLRRLLR";
        int n = positions.length;
        int robots[][] = new int[n][4];
        for(int i = 0; i < n; i++){
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i) == 'R'? 0 : 1;
            robots[i][3] = i;
        }
        
        Arrays.sort(robots, (a,b) -> (a[0] - b[0]));
        
        System.out.println(Arrays.deepToString(robots));
        
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i< n; i++){
            int health = robots[i][1];
            int dtn = robots[i][2];
            if(dtn == 1){
                boolean alive = true;
                while(!st.empty() && robots[st.peek()][2] == 0){
                    int top = st.peek();
                    if(health > robots[top][1]){
                        st.pop();   
                        health--;
                        robots[i][1] = health;
                        continue;
                    }else if(health < robots[top][1]){
                        robots[top][1]--;
                        alive = false;
                        break;
                    }else{
                        st.pop();
                        alive = false;
                        break;
                    }
                }
                if(alive){
                    st.push(i);
                }
            }else{
                st.push(i);
            }
            
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!isEmpty){
            int i = st.pop();
            ans.add(robots[i][1]);
        }
        
        
        
        // Arrays.sort(robots, (a,b)-> (a[3]-b[3]));
        // System.out.println(Arrays.deepToString(robots));
        
        
        
        
        while(!st.isEmpty()){
            int i = st.pop();
            System.out.print(robots[i][1]+" ");
            System.out.print(robots[i][3]+" ");
        }
  
    }
}