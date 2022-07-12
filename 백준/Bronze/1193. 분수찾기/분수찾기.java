import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int n;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int index=0;
        int sum=0;

     // 어느 행에 들어갈것인가?  (몇번째 그룹인지 체크)
        while(true){
            index++;
            sum = index * (index +1) / 2;

            if( n <=sum) break;
        }
    // 그 행에서 몇번째 값인지?
        int num = n - (index-1) * index / 2;

    // 짝수 행인지 홀수 행인지?

    if (index % 2 ==0) System.out.printf("%d/%d",num, index-num+1);
    else  System.out.printf("%d/%d", index-num+1, num);

    }
}
