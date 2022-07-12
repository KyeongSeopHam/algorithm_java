import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
     // 버퍼더리더로 데이터를 입력받아보자
     // 스트링 토크나이저를 이용해 값을 분리해서(토큰) 사용하자 -> 값이 커질수있으니
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //stringTokenizer = new StringTokenizer(bufferedReader.readLine()에서
        // 데이터를 입력받음 ex) 5,3
        // 그걸가지고 내려가서 각 변수에서 짤라줌
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // EX) suNo,quizNo => 5,3  (5개의 숫자를 입력받아서) (3개의 질문을던진다 (범위지정해서 i~j) )
        int suNo   = Integer.parseInt(stringTokenizer.nextToken()); // 몇개의데이터를 입력받을지
        // 버버더리더로 이미 받아왔는데 공백을 통해서 짤라준걸 suNo에 대입 quiz
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // 몇개의 데이터를 질문할지

        // 합배열을 만들자 데이터가 들어올테니
        long[] S = new long[suNo+1]; // snNo가 아닌 suNo+1 인 이유는  ex) 합배열공식같은거 보기쉬우라고
                                    // 배열은 0 번쨰 인덱스로 시작하지만 보기에는 1부터가 편하니까
        //long type인 이유는 데이터 초과를 대비해서 크게 잡자.

        // 32번라인 이부분이 suNo만큼의 데이터를 한줄로 입력받는다 ex 5 4 3 2 1
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<=suNo; i++){   //합배열공식
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int q = 0; q<quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // i ~ j 까지 범위 지정
          int i = Integer.parseInt(stringTokenizer.nextToken());
          int j =  Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j]-S[i-1]); // 구간 합 출력
        }
    }
    
}