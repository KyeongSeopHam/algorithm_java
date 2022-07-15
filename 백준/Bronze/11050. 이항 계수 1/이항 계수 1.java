import java.io.BufferedReader;
import java.util.Scanner;

class NcR {

    public long nCr(int n, int r){


        // N
        long num=1; long denom = 1;

        for(int i=0; i< r; i++){
            num =  num * (n-i);  denom = denom * (i+1);
        }

        return num/denom;
    }
}






public class Main {



    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();
        int r =sc.nextInt();



        System.out.println(new NcR().nCr(n,r));

    }


}

