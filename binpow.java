// Testing: https://cp-algorithms.com/algebra/binary-exp.html

public class Main
{
	public static void main(String[] args) {
		System.out.println(binpow(3,0));
		System.out.println(binpow(3,1));
		System.out.println(binpow(3,2));
		System.out.println(binpow(3,3));
		System.out.println(binpow(3,4));
		System.out.println(binpow(3,5));
		System.out.println(binpow(3,500));
		System.out.println(Math.pow(3,500));
		System.out.println(binpow(500,3));
		System.out.println(binpow(50,50));
		System.out.println(Math.pow(3,500));

		System.out.println(binpow(3,500,true));
	}

	public static long binpow(long a, long b, boolean verbose) {
        if (b == 0)
            return 1;
        long res = binpow(a, b / 2, verbose);
        if (b % 2 != 0) {
            if(verbose) System.out.println("b: "+b+" => "+res+"*"+res+"*"+a+" = "+res*res*a);
            return res * res * a;
        }
        else {
            if(verbose) System.out.println("b: "+b+" => "+res+"*"+res+" = "+res*res);
            return res * res;
        }
    }

	public static long binpow(long a, long b) {
	    return binpow(a, b, false);
	}

}
