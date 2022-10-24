
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
61423  ---->  64321


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String c[] = new String[s.length()];

        for (int i = 0; i < c.length; i++) {
            c[i] = s.substring(i, i + 1);
        }

        Arrays.sort(c);
        //3232->2233


        for(int i=s.length()-1; 0<=i; i--){
            System.out.print( c[i] );
        }


//        for(int i=s.length(); i<=0; i--){
//            System.out.print(c[i]);


    }
}
