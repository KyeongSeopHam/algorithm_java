import java.util.Scanner;

public class Main{

    public static int[] arr;  public static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  int M = sc.nextInt();
        /**
         * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
         * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
         * 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분
         *   3 2 ->  1,2 , 1,3 -> ... 3,1, 3,2,
         *  N,M이 주어지고 -> 중복 제외 -> 모든 경우의수  출력
         *  재귀 -> 이미 방문한 노드값 -> 다음 노드 탐색 -> in []
         */

        arr=new int[M]; // 깊이
        visit = new boolean[N];
        dfs(N,M,0);

    }

    public static void dfs(int N, int M, int depth){

        if(depth==M){
            for(int val:arr){
                System.out.print(val +" ");
            }
            System.out.println();
            return ;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){

                visit[i]=true;
                arr[depth] = i+1;
                dfs(N,M,depth+1);

                visit[i]=false;
            }
        }
        return ;
    }
}