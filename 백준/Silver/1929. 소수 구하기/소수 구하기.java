import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1은 소수가 아니므로 삭제
 M이상 N이하의 소수를 모두 출력하는 프로그램을 뽑아라  ORDER BY ASC
 ex) 1~16
 2부터 N의 제곱근까지만 탐색 => 16 (2^4)  인덱스 4까지만 탐색
 값이 인덱스값이면 그대로 두자  => 소수로 인정
 그 값의 배수를 탐색해 0으로 변경 => 소수 X
 문제에선 3이상 16이하에 대한부분을 탐색해서 값들을 출력 2는소수지만 3이상이므로 제외

 N의 제곱근까지만 탐색하는이유
 N=AXB 는   루트N 보다 클수없다.
 루트N X 루트N 는 = N
 그런데 AXB 도 N 이다 ?
 만약 A가 루트N보다 크다고하면은 B는 구조상  루트N보다 절대 못크다.
 루트 N을 2번곱하면 N이되는데  음

 A X  B   = N    = 루트N X 루트N

 루트N X 루트 N 는 딱 절반  N
위에서 가정을하자면 A가 루트N보다 크다고 가정을하면은 B가 루트N보다 클수가없다는뜻이다. 초과해버리니

그래서 N이 주어지면 루트 N까지만 가가지고 검색을해보고  루트N까지만 그 해당하는 값의 배수를 지워주면
 전체 소수를 판별할수 있다.



 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] A = new int[N+1]; // 1부터 보기좋게 하기위해서
        for(int i=2; i<=N; i++){
            A[i] = i;
        }

        for(int i=2; i<=Math.sqrt(N); i++){
            if(A[i]==0) continue;
            for(int j=i+i; j<=N; j=j+i){
                A[j] =0;
            }
        }

        for(int i=M; i<=N; i++){
            if(A[i]!=0){  // 소수일떄만 출력
                System.out.println(A[i]);
            }
        }
    }
}
