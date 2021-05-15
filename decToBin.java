
public class decToBin
{
    public static String decToBin_Str(int i) {

        String bin="", sign="";
        if(i<0) {
            sign="-";
            i=Math.abs(i);
        }
        while (i/2 > 1) {
            bin=(""+(i%2))+bin;
            i/=2;
        }
        bin=(""+(i%2))+bin;
        bin=sign+(""+(i/2))+bin;
        return bin;
    }

    public static String decToBin_Rec(int i) {
        if(Math.abs(i/2) <= 1) return (i<0?"-":"")+(Math.abs(i/2))+(Math.abs(i%2));
        else return decToBin_Rec(i/2)+(Math.abs(i%2));
    }

    public static String decToBin_RecClean(int i) {
        String res=decToBin_Rec(i);
        if(res.substring(0,2).equals("-0")){
            res="-"+res.substring(2);
        } else if(res.substring(0,1).equals("0")){
            res=res.substring(1);
        }
        return res;
    }

    public static String decToBin_Bin(int i) {
        return Integer.toBinaryString(i);
    }


	public static void main(String[] args) {

		System.out.println(decToBin_Str(64));
		System.out.println(decToBin_Bin(64));
		System.out.println(decToBin_Str(-2));
		System.out.println(decToBin_Bin(-2));
		System.out.println(decToBin_Str(-1));
		System.out.println(decToBin_Str(-0));
		System.out.println(decToBin_Str(-3));
		System.out.println(decToBin_Str(-4));

		System.out.println(decToBin_Rec(64));
		System.out.println(decToBin_Rec(-64));
		System.out.println(decToBin_Rec(-2));
		System.out.println(decToBin_Rec(2));
		System.out.println(decToBin_Rec(1));
		System.out.println(decToBin_Rec(0));
		System.out.println(decToBin_Rec(3));
		System.out.println(decToBin_Rec(4));
		System.out.println(decToBin_Rec(-1));
		System.out.println(decToBin_Rec(-0));
		System.out.println(decToBin_Rec(-3));
		System.out.println(decToBin_Rec(-4));

		System.out.println(decToBin_RecClean(1));
		System.out.println(decToBin_RecClean(0));
		System.out.println(decToBin_RecClean(-0));
		System.out.println(decToBin_RecClean(-1));
		System.out.println(decToBin_RecClean(-10));
		System.out.println(decToBin_RecClean(10));
	}
}
