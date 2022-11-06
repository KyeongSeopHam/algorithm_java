import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        /**
         * 최대공약수랑 최소 공배수를 구해야함.
         * 24 18  => 6  (최대공약수)
         * 24 18  => 72 (최소공배수)
         */

        int gcdResult = gcd(x, y); // 최대공약수
        System.out.println(gcdResult);
        System.out.println(x*y/gcdResult);
    }

    private static int gcd(int x, int y) { // 24  18
        if (y == 0) {                         // 18 6
            return x;                           // 6 0
        } else {                                  // y==0 return 6
            return gcd(y, x % y);
        }
    }
}
