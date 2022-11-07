
import java.util.*;

public class Main {

    static boolean visited[]; // 방문배열 체크용
    static List<Integer>[] A; // 리스트로 저장할거 노드(...엣지들)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //노드 개수
        int M = sc.nextInt(); // 엣지 갯수
        int Start = sc.nextInt(); // 시작점

        A = new ArrayList[N + 1]; //인덱스 1부터시작할거라 size+1
        for (int i = 1; i <= N; i++) {     // A인접 리스트의 각 ArrayList 초기화하기
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {  // A인접리스트에 그래프 데이터 저장하기
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

//        // 번호가 작은 것을 먼저 방문하기 위해 정렬하기.
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화하기
        DFS(Start);
        System.out.println();

        visited = new boolean[N + 1]; // 방문 배열 초기화하기
        BFS(Start);
        System.out.println();


    }

    private static void DFS(int Node) {  // 깊이우선탐색을 진행해보자. (시작점을들고)
        System.out.print(Node + " ");
        visited[Node] = true; // 처음 DFS들어오면 방문배열체크해주고
        for (int i : A[Node]) { // 체크된녀석부터들어와서 인접리스트애들을 꺼내줄건데
            if (!visited[i]) { // 인접리스트들의 원소들이 방문을 안했다면 다시 DFS
                DFS(i);
            }
        }
    }

    private static void BFS(int Node) { // 너비우선탐색을 진행해보자. (시작점을들고)
        Queue<Integer> queue = new LinkedList<>(); // 큐를 하나만들어주자.

        queue.add(Node); // 시작점을 처음이 추가해주자 FIFO     --IN-----OUT->
        visited[Node] = true; // 방문배열에 들어왔따고 채크를 해주자

        while (!queue.isEmpty()) { // 큐가 빌때까지 반복하자.
            int now_Node = queue.poll(); // 큐에서 하나꺼내자.
            System.out.print(now_Node + " "); // 꺼낸애를 탐색경로로 찍고

            for (int i : A[now_Node]) { // 바로위에서 꺼낸 인접리스트들을 하나씩 큐에추가시켜줄거다.(방문을안했다면)
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
