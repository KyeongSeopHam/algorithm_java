
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다
 둘째 줄부터 N개의 줄에는 수 주어진다.

 */


public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수의 갯수 입력

        int arr[] = new int[N]; // 배열 사이즈 초기화

        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 버블정렬 구현하는 영역
        // 마지막에는 2개가 한꺼번에 swap되니까 N-1까지만 가면된다.
        for(int i=0; i<N-1; i++){ // 루프가 몇번도는지
            for(int j=0; j<N-1-i; j++){ //루프가 한번돌수록 정렬된 데이터가 생기기떄문에 (하나의루프에도는루프가 좁아지기떄문에)
               if(arr[j]>arr[j+1]){
                   int tmp = arr[j+1];
                   arr[j+1] = arr[j];
                   arr[j] = tmp;
               }
            }
        }

        for(int item: arr){
            System.out.println(item);
        }
        
    }

}
