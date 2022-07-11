import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"D","C","B","A","E"};
        StringBuilder sb = new StringBuilder(); //StringBuilder를 사용하는 이유는 마지막에 한꺼번에 출력하기 위함

        // br.readLine() 을통해서 한줄을 읽어온다.
            /**
           * 1 과 0 으로 앞뒤 구분 (윷놀이 막대기 던지기)
             **/
        for(int i=0; i< 3; i++){   // 3줄을 입력받을예정 (3번의결과)
            StringTokenizer st = new StringTokenizer(  br.readLine());  // StringTokenizer는 문자열을 쪼갤 때 이용
             int sum=0;          // 입력받은 문자열의 token이 4개가 있기 때문
              // while (st.hasMoreTokens())는 이 StringTokenizer 변수 st에 token이 남아있을 때까지 loop을 돌립
             while(st.hasMoreTokens()){
                 sum+= Integer.parseInt(st.nextToken());
             }
             sb.append(arr[sum]+"\n"); //  StringBuilder 변수 sb에 append 시키는 이유는 마지막에 출력하기 위함
        }
        System.out.println(sb);

    }
}