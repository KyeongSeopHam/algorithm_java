import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테이스 케이스 갯수

        //      H(층),   , W (엘베부터->거리)호수,  N (번째손님)
        /* 입력값이 이렇게들어올거
                   2
                6 12 10
                30 50 72
         */

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // 매번케이스마다 T만큼반복

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
         // N=3 H=6 =>301호 /  N=12 H=6 => 602호
            if(N%H==0){ // N=12 H=6  12%6 ==0
                sb.append( (H*100) +(N/H) ).append("\n"); // 602호
            }else{  // N=3 H =6   301호
                sb.append( ((N%H)*100) + ((N/H)+1) ).append("\n");

            }
        }
        System.out.println(sb);


    }

}


