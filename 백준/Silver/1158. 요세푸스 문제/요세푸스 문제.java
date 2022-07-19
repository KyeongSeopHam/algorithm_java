import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
@author
 1158번 : 요요세스
1 ~ N 원
 k<= N일때  -> 순서대로 K번쨰 사람을 제거한다.

 -> 한사람이 제거되면 남은 사람들도 이루워진 원을 따라 이과정을 반복

 (N명의 사람이 모두 제거될떄까지 계속반복)

 (N,K)->요세푸스 순열

 ex) (7,3) -> 요세푸스 순열은 3 6 2 7 5 1 4
 1 2 3 4 5 6 7  -> 1 2 (3)
 4 5 6 7 1 2    -> 4 5 (6)
 7 1 2 4 5      -> 7 1 (2)
 4 5 7 1  ->  4 5 (7)
 1 4  5 ->   1  4  (5)
 1 4    ->   1   4 (1)
 4    -> 4 4  (4)

첫줄에 N, K

 */

public class Main {
 public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      Queue<Integer> q = new LinkedList<Integer>();
      // 1~ n 번까지 사람.
         for(int i=1; i<=n; i++){
           q.offer(i);
         }
      StringBuilder sb = new StringBuilder();
         sb.append("<");
         // 큐의 사이즈가 1이 될때까지 돌리자
          while( q.size() !=1){
             for( int i=0; i< k-1; i++){   // k-1까지 처음에 있던 값을 맨 뒤로 보내자
                 q.offer(q.poll());  
      
              }
           sb.append(q.poll()).append(", ");  // n번쨰가 뽑힐때마다 추가해주자
          }
          // 마지막 값
              sb.append(q.poll()).append(">"); // 마지막한명을 추가해주자.
               System.out.println(sb);
        }
    }