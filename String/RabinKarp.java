import java.util.Scanner;

public class RabinKarp{

    static int MAXN = 100000+5;     
    static int p = 31;
    static int m = (int)1e9 + 9;
    static long[] powers = new long[MAXN];              //stores powers of all the values.
    static int primeInv = 838709685;                    //PrimeInverse of 31 and 1e9+9

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String A = scan.nextLine();
        int q = Integer.parseInt(scan.nextLine());

        while(q-- > 0){
            String B = scan.nextLine();
            int count = countOccurences(A,B);
            System.out.println("count : "+ count);
        }
        scan.close();
    }

    public static int countOccurences(String A, String B){
        int count =0;
        int N=A.length(),M=B.length();
        powers[0] = 1;
        for(int i=1;i<=M-1;i++)     powers[i] = (powers[i-1] * p) % m;

        long hashA=0,hashB=0;

        //calculating Hash Functions
        int i;
        for(i=0;i<=M-1;i++){
            hashA = (hashA + value(A.charAt(i)) *powers[i]) % m;
            hashB = (hashB + value(B.charAt(i)) *powers[i]) % m;
        }

        for(i=M;i<N;i++){
            if(hashA == hashB)  {count++;System.out.println("matching at :"+(i-M));}  
            hashA = (hashA - value(A.charAt(i-M)) + m)*primeInv % m;
            hashA = (hashA + value(A.charAt(i)) * powers[M-1] ) % m;  
        }

        return count;
    }

    //This function returns the value of the ith char string.
    private static int value(char c){
        return (int)c;
    }
}