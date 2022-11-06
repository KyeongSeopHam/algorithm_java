
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
 * S에는 QR Code "alphanumeric" 문자만 들어있다.
 * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 * <p>
 * 2
 * 3 ABC  AAABBBCCC
 * 5 /HTP /////HHHHHTTTTTPPPPP
 * <p>
 * -> 음  2개의 INPUT 값   N = 2  Inte.par(br.rd) 2번의데이터를 입력받을거임
 * -> M의 수의길이만큼 문자열을받을거
 * -> charAt(0) ~ charAt(M-1) 만큼  각각 M만큼 반복해서 어펜드를 통해서 버퍼에 넣자.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int a = 0; a < str.length(); a++) {
                for (int b = 0; b < M; b++) {
                    sb.append(str.charAt(a));
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}