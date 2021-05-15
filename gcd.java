// Implementing following in Java:
// https://cp-algorithms.com/algebra/euclid-algorithm.html

public class MyClass {
    public static void main(String args[]) {
      int[][] t={{4,6},{7,8},{2,8},{0,0},{0,5},{5,0},{100,101},{100,120},{-1,3},{-10,-15}};
      boolean ok=false;

      for(byte i=0;i<t.length;i++) {
        System.out.println("GCD("+t[i][0]+","+t[i][1]+") : " + MyClass.gcd(t[i][0],t[i][1]));
        System.out.println("LCM("+t[i][0]+","+t[i][1]+") : " + MyClass.lcm(t[i][0],t[i][1]));
        ok=MyClass.gcd(t[i][0],t[i][1])==MyClass.gcdItr(t[i][0],t[i][1]);
        if(!ok) System.out.println("GCD rec=itr? : " + ok);
      }
    }
    public static int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static int gcdItr(int a, int b) {
        while(b!=0){
            int c=a;
            a=b;
            b=c%b;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        if(a==0 && b==0) return 0;
        else if(a==0 || b==0) return (a==0)?b:a;
        else return a/MyClass.gcd(a,b)*b;
    }
}
