
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**

        1  2 3 4 5 6 7 8
 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.

 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.


 */

public class Main {
    public static void main(String[] args) throws IOException {

        int[] arrA ={1,2,3,4,5,6,7,8};
        int[] arrB ={8,7,6,5,4,3,2,1};

        Scanner sc = new Scanner(System.in);
        int [] nums = new int[8];

        for(int i=0; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }
        if(Arrays.equals(nums,arrA)){
            System.out.println("ascending");
        } else if(Arrays.equals(nums,arrB)){
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }

    }

}