import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();

        int N = sc.nextInt();  // N을 입력받자.

        // 카드가 1~ N까지 있다함  => 큐 초기화
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 큐에 1장이 남을떄까지 반복
        while(queue.size() >1){
            queue.poll();  // 큐버리고
            queue.add(queue.poll()); //큐에서 꺼내서 뒤로집어넣고
        }
        
        System.out.println(queue.element().toString());


    }
}
