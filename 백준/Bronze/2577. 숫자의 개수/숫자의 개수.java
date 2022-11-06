import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10]; // 숫자담을배열 0 1 2 3 4 5 6 7 8 9
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        int a3 = Integer.parseInt(br.readLine());
        int a = a1 * a2 * a3;
        String str = String.valueOf(a); //  int a -> String a
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++; //  아스키코드문자0 = 아스키코드표현법:48 또는'0' => a=0이라면 48-48= 0(10진수) 배열[0]++
        }
        for (int item : arr) {
            System.out.println(item);
        }
    }
}