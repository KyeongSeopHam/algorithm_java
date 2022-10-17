
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
    N장의 카드가 있음.
   - 카드는 차례로 1부터 N까지의 번호가 붙어있음
   - 1번 카드가 제일 위에 , N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여있음

  => 동작원리 : 0. 카드가 한장 남을떄 까지 반복하는데
              1. 제일 위에 있는 카드를  바닥에버린다.
              2. 그 후에 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

     EX) N = 4일떄  제일 위에서부터 1 2 3 4 순서대로있음
   1을 버리면(  2(TOP) 3 4 )가 남는데  =>  3 4  2 로
  0번의조건이만족할떄까지 해보자.   (3 4 2) 에서 => 2 4
   2 4 => 4

  첫째 줄에 정수 N(1<=N<=500,000) 50만이 주어진다.

 ===================================================

 그럼 어떻게 해결해야할까?

 큐의 구조를 살펴보면은   먼저 들어온것이 먼저 나가는 성질을 가지고있다. FIFO
  IN [  4  3  2  1  ]-> OUT

   N을 입력받는다.
 큐생성및 초기화 : 큐에 데이터를 N만큼 초기화시켜준다. (순차적으로 1~N)
 큐의 사이즈가 1일떄까지반복
 <<<<<<
 큐의 프론트(맨앞) 부분을 I번쨰 PULL
 그리고 I+1번쨰 PULL한걸 맨뒤로 삽입
 >>>>>>>>
 큐의사이즈가 1이면 그 값을 출력

 */




public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue queue = new LinkedList();


        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        int temp=0;

        while(queue.size()!=1){

            queue.poll();
            temp = (int) queue.poll();
            queue.add(temp);

            if(queue.size()==1){
                break;
            }
        }
        System.out.println(queue.peek());
    }
}
