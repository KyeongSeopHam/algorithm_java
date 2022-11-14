import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    //1 ≤ k, n ≤ 14
    public static int[][]APT = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        make_APT(); // 아파트 생성 1~14층짜리
        int T = Integer.parseInt(br.readLine()); // 테이스 케이스

        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());  // 정수k  층
            int n = Integer.parseInt(br.readLine());  // 정수n  호
            sb.append(APT[k][n]).append("\n");         // 해당 집에 거주민 수를 출력해라
        }
        System.out.println(sb);

    }
  //1 ≤ k, n ≤ 14
    private static void make_APT(){

        for(int i=0; i<15; i++){
            APT[i][1]=1;  //i층 1호
            APT[0][i]=i;  //0층 i호
        }
        for(int i=1; i<15; i++){
            //1~14층까지
            for(int j=2; j<15; j++){
                //2호~14호까지 1호는 1로 다초기화했으니까 뛰어넘고
                APT[i][j]= APT[i][j-1] + APT[i-1][j];
            }
        }


    }

}

