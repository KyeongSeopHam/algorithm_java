import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        int sum=1;  // 처음에 둘다 1을 가리키니까
        int count=1; // while() 만약 15가 입력값이라고 하면 15 한개만 뽑는 경우도 연속된 것으로 볼수 있기 때문에 이 경우를 미리 카운트 해준 것
        int endIndex = 1;
        int startIndex =1;

        while(endIndex!=N){
            if(sum==N){
                count++; endIndex++; sum = sum + endIndex;
            }else if(sum>N){
                sum = sum - startIndex; startIndex++;
            }else{  //sum<N
                endIndex++; sum = sum + endIndex;
            }
        }
        System.out.println(count);


    }
}