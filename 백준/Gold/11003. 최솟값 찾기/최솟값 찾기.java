import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한번에 출력하기위해 버퍼드라이트 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> mydeque = new LinkedList<Node>();

        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올때마다 정렬대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄이고자함
            //반복할건데 ( 큐가 비어있지않다면 && 큐의마지막값이 > now(현재값보다 크다면)
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast(); // 그렇다면 큐의 마지막부분을 삭제
            }
            mydeque.addLast(new Node(i, now)); // 그리고 이전에 큐값이 컸으므로 위부분에서 삭제가 이루워졌고 비교한데이터(뜰어올데이터를)삽입

            // 범위(L)에서 벗어난 값은 덱에서 제거해야 하는 케이스  (밑 코드)
            // L=3일떄(윈도우구간)  데이터가 1,2,3일떄 4가들어올떄 범위초과
            // 첫번쨰부분 getFirst().index ( 1 )   <= (들어오는값 i가4일때 - L(3)) =1이므로 같으므로 범위초과
            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst(); // 큐맨앞삭제(윈도우범위초과)
            }
            bw.write(mydeque.getFirst().value + " "); // L만큼의윈도우구간 위에서 비교해서 최종적인 (최소값 찍기)
        }
        bw.flush();
        bw.close();
    }



    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
