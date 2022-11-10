
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이번문제 재밌네 
// 카운트정렬로 풀어보기 10989

public class Main {

    public static void main(String[] args) throws IOException {

        int[] cnt = new int[10001];  // 0~10000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N개의 수가 주어졌을떄 /  오름차순 정렬해라

        for(int i=0; i<N; i++){
            cnt[Integer.parseInt(br.readLine())]++; // 오 이방법좋네  여기서 카운트정렬
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        /**
         정렬전 5  2  3  1  4  2  3  5  1   7
         =======================================================
         결과  1   1  2  2 3  3  4  5  5   7
         */
        // 0은 입력범위에서 없으므로 1부터 시작
        for(int i=1; i<10001; i++){
    // i값이 개수가 0이 될떄까지 출력 (빈도수를 의미)
            while(cnt[i]>0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }   
        System.out.println(sb); 

    }
}

