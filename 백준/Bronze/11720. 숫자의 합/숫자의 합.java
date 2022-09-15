
import java.util.Scanner;

public class Main {

    /**
     *  11720번
     첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
     N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
     입력으로 주어진 숫자 N개의 합을 출력한다.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();



        String sNum = sc.next();
        char[] cNum = new char[N];

         cNum =sNum.toCharArray();

        int sum =0;

        for(int i=0; i<cNum.length; i++) {
            sum += cNum[i] - 48;

        }
        System.out.println(sum);



    }
}
