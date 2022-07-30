import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {


    static int N;  static int M;
    static int[] arr;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr=new int[M];
        DFSDFS(0);
        System.out.println(sb);


    }

    private static void DFSDFS(int depth){
        if(depth==M){
            for(int item:arr){
                sb.append(item+" ");
            }
            sb.append("\n");
            return ;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i+1;
            DFSDFS(depth+1);
        }

    }

}