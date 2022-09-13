
import java.util.Scanner;
import java.util.Stack;

/**
  1874번 스택 수열
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 갯수를 받자.
        int box[] = new int [N];

        for(int i=0; i<N; i++){  // 실제로데이터를받자
            box[i] = sc.nextInt();  // N만큼의 데이터 삽입
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean result = true; // no찍은거 확인용

        // 오름차순으로 해야되는 조건이있음 당연히 스택이니까

        int number = 1; //1부터~~시작 오름차순


        StringBuffer bf = new StringBuffer();
        //수열 탐색
        for(int i =0;  i < box.length; i++){
            int su = box[i];

            // 배열에있는값이 오름차순값보다 클경우 같아질때까지 반복
            if( su >= number){
                while(su>=number){
                    stack.push(number++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{    //작거나 같은경우
                int n = stack.pop();

                if(n>su){  // 여기안걸릴경우 밑으로가는데 수가 똑같은경우
                    System.out.println("NO");
                    result= false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
    if(result){
        System.out.println(bf.toString());
    }

    }
}
