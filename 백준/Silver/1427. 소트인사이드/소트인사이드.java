import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
  // "234" -> 432

        Scanner sc = new Scanner(System.in);

        String stringItem = sc.next();  // String type의 문자열 입력받고

        int intArrayItem[] = new int[stringItem.length()];  // String->int[]

        for(int i=0; i<stringItem.length(); i++){
            intArrayItem[i] = Integer.parseInt(stringItem.substring(i,i+1));

        }
        //선택정렬
        for(int i=0; i<stringItem.length(); i++){
            int max =i; // 최대값 기본 설정
            for(int j= i+1; j<stringItem.length(); j++){
                if(intArrayItem[j] >intArrayItem[max]){
                    max=j;
                }
            }
        //swap 구간
            if(intArrayItem[i] < intArrayItem[max]){
                int temp =  intArrayItem[i];
                intArrayItem[i] =intArrayItem[max];
                intArrayItem[max] = temp;
            }
        }
        for(int i=0; i<stringItem.length(); i++){
            System.out.print(intArrayItem[i]);
        }
    }
}