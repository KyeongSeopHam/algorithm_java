import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int arr[] = new int[N];

        for(int i=0; i<arr.length; i++){

            arr[i] =  scanner.nextInt();
        }

        Arrays.sort(arr);
        
        for(int item:arr){
            System.out.println(item);
        }
    }


}
