
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();  // 수 ( 갯수)
        int M = sc.nextInt();  //(%) 나누어떨어져야하는수
        long [] S = new long[N];   // 합배열
        long []count= new long[M];  // 카운트세줄놈 0중복,1중복갯수
        long result =0; // 정답
        S[0] = sc.nextInt();


        for(int i=1; i<N; i++){     // 합배열 Set
            S[i] = S[i-1] +sc.nextInt();
        }


        for(int i=0; i<N; i++){
            int rest = (int) (S[i] % M);  // 합배열 모든 값들에다가 % 해주기

            if(rest ==0) result++;  // 0~ i까지의 구간 합 자체가 0일때 정답에 더하기
            count[rest]++; // 나머지가 같은 인덱스의 갯수 카운팅하기
        }

        for(int i=0; i<M; i++){
            if(count[i]>1){
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                result = result + (count[i] * ( count[i]-1) / 2 );
            }
        }
        System.out.println(result);
    }
}
