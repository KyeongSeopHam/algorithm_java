
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb;

        int N = Integer.parseInt( new StringBuilder(st.nextToken()).reverse().toString());
        int M = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        
        System.out.println(N>M?N:M);
    }
}