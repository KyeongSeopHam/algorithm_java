
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 배열은 (0,0) 시작
    // 상,하 , 좌,우
    static int [] dx = {0,1,-1,0};
    static int [] dy = {-1,0,0,1};

    static boolean[][]visitd;
    static int[][]A;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A =new int[N][M]; // 2차원배열생성해주고
        visitd= new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); // 한줄쭉읽어서
            String line =st.nextToken(); //첫줄 1010101010 이런식으로 데이터들어갈텐데
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1)); // 하나씩짤라서 0,0부터 ~~넣자
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);


    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visitd[i][j] = true; // 처음 방문체크

        while(!queue.isEmpty()){ // 큐카 empty일떄까지 돌릴거
            int now[] = queue.poll(); // 뽑아
            for(int k=0; k<4; k++){  // 원본기준으로(레벨단계마다)상하좌우탐색돌려돌려
                int x=now[0]+dx[k];
                int y=now[1]+dy[k];

                if( x>=0 && y>=0 && x<N && y<M){ // 범위체크 <좌표 유효성 검사>
                    if(A[x][y] !=0 && !visitd[x][y]){ //0은탐색안할거, 방문했다면 x 조건
                        visitd[x][y] = true; // 위조건뚫었으면 방문 ㄱㄱㄱ
                        A[x][y]=A[now[0]][now[1]] +1;  // 깊이 업데이트하기
                        /*이게몬소리냐 A[now[0]][now[1]] 원본의위치(기존값)을 가지고
                     처음기존값{0,0} = 1 일틴데
                     A[x][y] 새로방향검사해서 온곳에 기존값에+1을해주겠다는거 그럼 2
                     방문하면서 업데이트하는효과
                         */
                        queue.add(new int[]{x,y});
                    }

                }

            }

        }
    }
}

