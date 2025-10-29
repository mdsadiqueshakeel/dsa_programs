package Basics;
public class prime {
    // public static void main(String[] args) {
    // int n = 15;
    // int cnt= 0;
    // for(int i = 1; i*i <= n ; i ++){

    // if(n%i==0){
    // cnt++;
    // if((n/i)!=i){
    // cnt++;
    // }
    // }
    // }if (cnt == 2){
    // System.out.println(n+" is prime number");
    // }else{
    // System.out.println(n+ " is composite number");
    // }

    // }

    public static void main(String[] args) {
        int n1 = 20;
        int n2 = 18;
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            }
            else{
                n2 = n2 % n1;
            }
        }
        System.out.println((n1 == 0) ? n2 : n1);
    }
}
