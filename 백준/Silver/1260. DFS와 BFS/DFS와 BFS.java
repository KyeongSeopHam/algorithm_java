import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[]A;
    static boolean []visitd;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // N 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // M 간선의 개수
        int V = Integer.parseInt(st.nextToken());  // V 탐색 시작 정점 번호

        A = new LinkedList[N+1];   // 정점의 갯수만큼 리스트 생성
        visitd = new boolean[N+1]; // 정점의 갯수만큼 방문배열 생성

        for(int i=1; i<=N; i++){ //
            A[i] = new LinkedList<>();  // A인접리스트의 각 LinkedList 초기화하기
        }

        for(int j=1; j<=M; j++){
            st = new StringTokenizer(br.readLine()); // A인접리스트에 그래프 데이터 저장하기
            int a = Integer.parseInt(st.nextToken());  // a
            int b = Integer.parseInt(st.nextToken());  // b
            A[a].add(b);
            A[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);   // 번호가 작은 것을 먼저 방문하기 위해 정렬하기.
        }
        
        DFS(V);
        System.out.println();
        
        visitd = new boolean[N+1];
        BFS(V);
        System.out.println();


    }



    private static void DFS(int v) {  //DFS 깊이우선탐색 (탐색결과를뽑아야하므로)
        System.out.print(v+" "); // 처음에 들어온숫자 찍고
        visitd[v] = true;  // 방문했다고 체크해주고
        for(int item : A[v]){   // v의 인접리스트 탐색
            if(!visitd[item]){ // 꺼낸애가 방문안한노드면
                DFS(item); // 들어가서 탐색
            }
        }
    }

    private static void BFS(int v) { //  BFS 너비우선탐색 레벨탐색
        Queue<Integer> queue = new LinkedList<>(); // 큐하나 생성
        visitd[v] = true; // 방문배열체크해주고
        queue.add(v); // 처음탐색할애를 넣는다.


        while(!queue.isEmpty()){
            int now_Node = queue.poll(); // 처음에하나꺼내자, 그리고 변수에담아주고 인접리스트쓰기위해서
            System.out.print(now_Node+" "); // 꺼낸얘 경로에 찍고
            for(int item: A[now_Node]){ //꺼낸에 인접리스트 탐색
                if(!visitd[item]){
                    visitd[item] =true;
                    queue.add(item);
                }
            }

        }

    }
}
