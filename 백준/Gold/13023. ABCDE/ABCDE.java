
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean visited[]; // 방문배열
    static List<Integer>[] A; // 인접리스트 데이터저장을위해서 배열리스트
    static boolean arrive; //도착확인변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive = false;
        A = new ArrayList[N]; // 그래프 데이터 저장 인접 리스트
        visited = new boolean[N]; // 방문 기록 저장 배열
        for (int i = 0; i < N; i++) {  // A인접 리스트의 각 ArrayList init
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // a
            int E = Integer.parseInt(st.nextToken()); // b
            A[S].add(E); // 양방향
            A[E].add(S);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1); // 0부터들어갈건데 depth는 1부터 5되면 출력1 아니면 0
            if (arrive) break;
        }
        if (arrive) { // depth 5라면 t 1 else 0
            System.out.println("1");
        } else {
            System.out.println("0");
        }


    }

    private static void DFS(int now, int depth) { // DFS 구현
        if (depth == 5) { //depth가5거나 도착했다면
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}

