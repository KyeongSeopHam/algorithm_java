
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
     // N 재료  // M 갑옷
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());   // N 재료
        int M = Integer.parseInt(bufferedReader.readLine());  // M 갑옷
       /**
        *   6  -> 3번째의 값 : 각각의 재료 item Sum = 6
        *   9  M 갑옷 (갑옷을 만들려면 M만큼 필요로 한다)
        *   2 7  4 1  5 3  (각각의 재료item)
        */
        int [] arritem = new int[N];
        StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++){

            arritem[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arritem);
        /**
         6
         9
         2 7 4 1 5 3
          정렬후  2 7  4 1  5 3 -> 1,2,3,4,5,7
           min값과 max값을 만들어주자.
         */
        int resultItemCount=0;
        int min =0;  int max = N-1; // 재료의 끝갯수

        while(min<max){
            if(arritem[min] + arritem[max] < M) {
                min++;
            }else if(arritem[min] + arritem[max] > M){
                max--;
            }else {
                resultItemCount++;
                min++;
                max--;
            }
        }
        System.out.println(resultItemCount);


    }
}