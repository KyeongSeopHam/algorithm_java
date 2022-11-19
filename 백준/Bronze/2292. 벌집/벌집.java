import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		int count = 1; // 법집 한바퀴 
		int range = 2;	// 1은있으니 2부터시작할거임 
 
		if (N == 1) { 
			System.out.print(1);
		}
              // 1 - -----> 6 -> 12 -> 18 -> 24 ...
		else {   
			while (range <= N) {	// 범위가 N보다 커지기 직전까지 반복 
				range = range + (6 * count);
				count++; // 이게 원하는값 처음엔 카운트 1시작 ->만족시 2 -> .....
			}
			System.out.print(count);
		}
	}
}