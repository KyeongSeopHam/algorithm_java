
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = sc.nextLong();
        long b = sc.nextLong();
        long resultGcd = gcd(a, b);

        for (int i = 1; i <= resultGcd; i++) {
            bw.append("1");
        }
        bw.flush();
        bw.close();
    }


    /**
     * a    b
     * 8   24
     * <p>
     * 8 % 24 = 8
     * 24%8=>  0
     * 8%0=>  8
     * b==0 -> 최대공약수8
     */

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);

    }

}
