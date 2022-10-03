
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 주어진 N개의 수 -> 입력받는다. => N개만큼
 * 2.  IF 다른 두 수의 합으로 표현되는 수 ?  => '좋은 수' 라고 함
 * 3.  N개의 수중 좋은 수가 총 몇개인가?
 * <p>
 * 시간복잡도   N  1<=N<=2000 /   2번쨰줄: Ai정수 |Ai| <= 10억
 * <p>
 * 문제를 보면 이게 몬소린가 하는데 접근방법
 * 10  배열저장후 (정렬했다고 가정)
 * 1,2,3,4,5,6,7,8,9,10
 * 1) 양끝 startIndex , endIndex 포인트로 잡고 ( 0 , N-1)
 * 그전에 문제부터 보면 좋은수가 도대체 모냐?
 * 배열의 모든수에서 반복이 이루워질건데  K가 N이 될떄까지 반복하며 좋은수가 몇개인지 카운트를 하자.
 * ==================================================================================
 * K가 숫자 1일때(0번째인덱스) 두 수(i,j)를 더해서 나올수가없는 케이스. 종료
 * K가 숫자 2일때(1번째인덱스) 두 수(i,j)를 더해서 나올수가없는 케이스. 종료
 * <p>
 * K는 N이될때까지 반복해서 좋은수를 체크할건데  1+2 = 3   1+3=4  1+4=5 .. 이런식으로
 * <p>
 * ??? < 정렬된 데이터에서 자기 자신을 좋은 수 만들기에 포함하면 안된다라는 뜻은? 무엇일까
 * 1,2,3,4,5가 있을대   i=2 j=3일때 현재 k=5일때 성립
 * 그런데 만약  i=2 , j=3  k=3 인 케이스를 말하는건가? 당연하게 두수를 합하면
 * 자신을 좋은수를 만들수없는 조건이기떄문에 당연한건데 이케이스를 말하는건지? I>J,I<J
 * <p>
 * i+j > k
 * i+j < k
 * i+j ==k
 * 투포인터 이동원칙 활용 -> 탐색 수행
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        long A[] = new long[N]; //시간복잡도 차원 크게설정

        StringTokenizer st = new StringTokenizer(br.readLine()); // 배열에 들어갈 값을 버퍼에넣어놓고

        for (int i = 0; i < N; i++) {  // N번만큼 돌거임
            A[i] = Long.parseLong(st.nextToken()); // 토큰으로 짤라서 한개씩 배열에박을거
        }
        Arrays.sort(A); //오름차순정렬

        // K 탐색 0부터 N까지 반복
        for (int k = 0; k < N; k++) {
            long findValue = A[k]; // 좋은수 A[k]==i+j 케이스 찾기
            int i = 0;    // frontIndex
            int j = N - 1;  //  endIndex

            // 투포인터 알고리즘 활용   i+j > k , i+j < k , i+j ==k

            while (i < j) {
                if (A[i] + A[j] == findValue) {
                    if (i != k && j != k) {  // finedvalue가 서로 다른 두수의 합이어야함을 체크해주는 부분 예외처리
                        result++;
                        break;

                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < findValue) {
                    i++;
                } else {
                    j--;
                }

            }
        }
        System.out.println(result);


    }
}
