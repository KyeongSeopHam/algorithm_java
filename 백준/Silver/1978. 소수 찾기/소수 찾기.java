import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static private int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
          isPrime(Integer.parseInt(st.nextToken()));
        }
        System.out.println(count);
    }

    static boolean isPrime(int num)  // 처음 21이 들어왔다고하면
    {

        if(num==1){
            return false;
        }
        // 23   1  23
        for (int i = 2; i <= Math.sqrt(num); i++)  //  21/2=10.5만큼반복    2 3 4 5 6 7 8 9 10
        {

            if (num % i == 0)   //여기에 걸리면 소수가아니므로 리턴
            {
                return false;
            }

        }


        count++;
        return true;
           // 여기까지 도달했다는뜻은  num%i==0  ( 1과 자신만으로 이루워진 수로 판별)
    }

}

