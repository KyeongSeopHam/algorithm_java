import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        // N X N이 주여졌을때 (X1,Y1) , (X2,Y2)까지의 합을 구하려고한다.
        int N = Integer.parseInt(st.nextToken()); // 표의 크기 (2차원 배열의 크기)
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수 (질의수)
        int A[][] = new int[N+1][N+1]; // 1부터표현하기위해  + 1

        for(int i=1; i<=N; i++) {   // N크기만큼 반복
            st = new StringTokenizer(br.readLine());  // 배열값 쭉 입력받고(i번쨰줄) And ++
            for(int j=1; j<=N; j++){  // 스트링토크나이저로 짤라서 데이터 밀어주기.
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 구간 합 구하기 [ 합배열 이용]  <정답판 만들어놓기>
         *  일단 D[][]을 만들어주고 -> (2,2)의 전체 합 구간을 구하고싶다면
         *   (1,2)의 가로부분, (2,1) 세로부분을 더해주면 겹치는부분 (1,1)을 뺴주고 + (2,2)을 더해주면
         *   (2,2)의 구간 합을 구할수 있다. 아래와 같다.
         */
        int D[][] = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                D[i][j] =  D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];

            }
        }

        /**
         *  위에서 구간 구간합을 이용해서 정답판을 만들어놨으니까 이용해보자.
         *  끼어 맞추기만 하면된다. 위의과정을 거치지않으면 좋지못한 알고리즘이 될수있다.
         *  질의를 통해서 바로  (x1,y1),(x2,y2)의 구간합을 구해보자.
         *
         */

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine()); // ex) 2 2 3 4 (x1,y1),(x2,y2) 1번째질의 ...

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer =  D[x2][y2] -  D[x2][y1-1] - D[x1-1][y2]   +D[x1-1][y1-1];
            System.out.println(answer);
            /**
             * 일단  (x1,y1),(x2,y2) 를 구하기전에
             * 0,0 -> (x2,y2) 전체 합구간을 가져온후 우리는   (x1,y1),(x2,y2) 을 구해야하므로
             * 총 전체에서 구해야하는 부분만 뺴주면된다. 그럼 어떻게 해야하는가?
             *  전체에서 뺼텐데 -> 가로부분 , 세로부분을 뺴주고 2번뻇으니 (가로,세로에서)공통된부분을 한번더해주면끝이다.
             */
        }




    }
}
