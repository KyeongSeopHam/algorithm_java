
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
 * (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다. => n^2 1000000
 */
public class Main {

    static List<Integer>[] A; // 리스트선언 (각각의리스트들의 데이터들을 담기위해서)
    static boolean visted[]; // 방문배열을 통해서 T / F 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수


        A = new ArrayList[N + 1]; // 객체 size N만큼 만들어놓고
        visted = new boolean[N + 1]; // 방문배열 size N만큼 생성해주고
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);  // 양방향 엣지이므로 양쪽에 에지를 add
            A[e].add(s);
        }

        int connectListCount = 0;
        for (int i = 1; i <= N; i++) {
            if (!visted[i]) {       //  방문하지 않은 노드가 없을떄 까지 반복 처리
                connectListCount++;
                DFS(i);
            }
        }
        System.out.println(connectListCount);
    }

    private static void DFS(int v) {

        if(visted[v]) return;  // 방문했다면 return

        visted[v] =true;

        for (int i : A[v]) {
            if (visted[i] == false) { // 연결 노드 중 방문하지 않았던 노드만 탐색하기
                DFS(i);
            }
        }

    }
}
