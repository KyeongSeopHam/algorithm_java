import java.util.Scanner;


public class Main {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        dfs(0);
        System.out.print(sb);

    }
//  1) 1 ~ N 까지의 수를 조합한다.
//
//  2) M 개를 선택하여 조합한다. (길이(깊이)가 M이다)
//
//  3) 중복해서 조합 할 수 있다.
    public static void dfs(int depth) {
  //N=3  M=2    1 1  1 2  1 3 ...-> 3 1 ... 3 3

        if(depth==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i] +" ");
            }sb.append('\n');
            return ;
        }
        for(int i=1; i<=N; i++){
            arr[depth]=i;
            dfs(depth+1);
        }


    }
}


