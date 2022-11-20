import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// !!!!!!!!!! 브루트포스 문제 !!!!!!!!!!!!!!!
// N M (카드수,  정할숫자합)
// N개의 카드수   3개만뽑아야하고 M보다크면안된다.
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 카드 수
        int M = Integer.parseInt(st.nextToken());  //  M숫자에 가까워진애를뽑아야함 얘보다크면 No

        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 카드 갯수만큼 카드 뿌리기
        }

        int result = search(arr, N, M);
        System.out.println(result);

    }

    static int search(int[] arr, int N, int M) {

        int result = 0; // 처음에 0으로시작

        for (int i = 0; i < N - 2; i++) {  // 5장이라면 3장만뽑을꺼
            if (arr[i] > M) continue;  // m보다 크면 나머지볼게없음

            for (int j = i + 1; j < N - 1; j++) {
                if (arr[i] + arr[j] > M) continue;  // m보다 크면 나머지볼게없음


                for (int k = j + 1; k < N; k++) {
                    int tmp = arr[i] + arr[j] + arr[k]; // 다더한값

                    if (tmp == M) {  // M이랑 뽑은애들3개값이 같으면 끝
                        return tmp;
                    }

                    if (result < tmp && tmp < M) {
                        result = tmp;     // result 갱신해줄건데 3개카드합이 이전애보다 크면 + M보다작다면 갱신
                    }
                }
            }

        }


        return result;
    }

}

