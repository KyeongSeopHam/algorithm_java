import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        BigInteger a =  new BigInteger(st.nextToken());
        BigInteger b =  new BigInteger(st.nextToken());

        System.out.println(a.divide(b));
        System.out.println(a.remainder(b));

    }
}