
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;


public class Main {

    static int N; // 자리수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 자리수 지정


        DFS(2, 1);  // DFS(2,3,5,7)하는이유? 뻗어나갈꺼니까 첫 소수의기준으로
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu)
    {
        if (jarisu == N)
        {    // 1. 자리수가 같으면서
            if (isPrime(number))
            { // 소수면 출력해라
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++)   // 범위가 1~<10인이유 그다음자릿수 1~9까지 탐색
        {
            if (i % 2 == 0)   // ex) 2,4,6,8일경우는 짝수므로 안본다는뜻 ) 그럼남는건 1,3,5,7,9
            {  //짝수라면 더이상 탐색 x
                continue;
            }
            if (isPrime(number * 10 + i)) // 처음2->2x 자리를만들어서 소수인지판별해야하므로
            {                                 //  2x10+i = 20 +1  = 21 이걸 isPrime(21)에 검사
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num)  // 처음 21이 들어왔다고하면
    {
   // 23   1  23
        for (int i = 2; i <= Math.sqrt(num); i++)  //  21/2=10.5만큼반복    2 3 4 5 6 7 8 9 10
        {
            if (num % i == 0)   //여기에 걸리면 소수가아니므로 리턴
            {
                return false;
            }
        }
        return true;    // 여기까지 도달했다는뜻은  num%i==0  ( 1과 자신만으로 이루워진 수로 판별)
    }
}
