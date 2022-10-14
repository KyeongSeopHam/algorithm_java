import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 크기 N인 수열 A = A1,A2,A3..An이 있다. /
 * 오큰수 NGE(i) 조건 : [Ai의 오큰수는] 오른쪽에있으면서 Ai보다 큰수중 가장 왼쪽에 있는 수  / 없을땐 -1
 * EX1) A = {3,5,2,7} 이라면   NEG(1)=5   NEG(2) = 7    NEG(3) = 7  NEG(4) = -1
 * EX2) A = {9,5,4,8}  =>    NEG(1) -1  NEG(2) =8    NEG(3) = 8  ENG(4) = -1
 * <p>
 * 워스트케이스를 보자
 * <p>
 * 1번째 줄에 수열 A의 크기  N  ( 1 < N < 1,000,000)
 * 2번쨰 줄에 수열 A의 원소  A1 , A2...An (1 <= A < 1,000,000)
 * <p>
 * <p>
 * 4가지 최악의조건을 보자면   4,3,2,1 => 총 1의 오큰수를 찾기위해서 3,2,1를 다비교  , #의 오큰수를 찾기위해서 2,1,랑 비교
 * 넉넉잡아서  N=4일떄  오큰수를 찾는걸 N/2 라고잡아도   4X2 = 8번
 * 1,000,000 X 500,000  =    이미 1억이넘어가므로 1초만에 풀수없다.
 */


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열의크기

        int[] A = new int[N]; // 수열 배열 생성
        int[] result = new int[N]; // 정답 배열 생성

//        String[] str = br.readLine().split(" "); // 토크나이저대신에 얘로 대채해도됨
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(str[i]);
           A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 항상 스택이 비어있으니까 최초값을 push해서 초기화

        for (int i = 1; i < N; i++) {
            // 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];  // 정답 배열에 오큰수를 현재 수열로 저장하기
            }
            stack.push(i); // 신규 데이터 push
        }

        while (!stack.empty()) {
            //반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌떄까지
            result[stack.pop()] = -1; // 스택에 쌓인 index에 -1을 넣고
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");  // 결과값 출력
        }
        bw.write("\n");
        bw.flush();

    }
}