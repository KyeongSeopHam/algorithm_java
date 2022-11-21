import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
        
		// N 이 0이 아닐 때 까지 1씩 감소하면서 sum에 반복적으로 곱해준다
		while(N != 0) {  // n -> n-1 n-2 n-3 n-4 n-5 .... 1 .. 0이될떄탈출
			sum = sum * N;
			N--;
		}
        
		System.out.println(sum);
		
	}
}