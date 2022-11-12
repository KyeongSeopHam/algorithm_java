
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        /*
        첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
        둘째 줄부터 N개의 줄에는 수가 주어진다.
         이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
         */

   //방법 2 BufferedReader + Counting Sort

    //절대값  - 1,000,000  (-백만)  ~ + 1,000,000 (백만)

        boolean[] arr = new boolean[2000001];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                sb.append((i - 1000000)).append('\n');
            }
        }
        System.out.print(sb);










/*
        //방법1 : BufferedReader + Collections.sort
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);



        for(int item : list){
            sb.append(item).append("\n");
        }
        System.out.println(sb);*/

    }


}



