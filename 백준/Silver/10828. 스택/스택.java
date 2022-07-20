
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

 명령은 총 다섯 가지이다.

 push X: 정수 X를 스택에 넣는 연산이다.
 pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 size: 스택에 들어있는 정수의 개수를 출력한다.
 empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */



public class Main {

    public static int[] stack;
    public static int size =0;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        stack = new int[n];

        StringTokenizer st;
        while(n>0){
            st = new StringTokenizer(bufferedReader.readLine()," ");

            switch(st.nextToken()){
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "size": sb.append(size()).append('\n'); break;
                case "pop": sb.append(pop()).append('\n'); break;
                case "empty": sb.append(empty()).append('\n'); break;
                case "top": sb.append(top()).append('\n'); break;

            }
            n--;
        }
        System.out.println(sb);




    }
    /**
     push X: 정수 X를 스택에 넣는 연산이다.
     pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     size: 스택에 들어있는 정수의 개수를 출력한다.
     empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
     top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
     // push X: 정수 X를 스택에 넣는 연산이다.
    public static void push(int x){
        stack[size] = x;
        size++;
    }
    // size: 스택에 들어있는 정수의 개수를 출력한다.
    public static int size(){
        return size;
    }
    // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int pop(){
        if(size==0){
            return -1;
        }else{
            int stackOutNumber = stack[size-1];
            stack[size-1]= 0;
            size--;
            return stackOutNumber;
        }
    }
    //     empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    public static int empty(){
        if(size==0) {
            return 1;
        }else {
            return 0;
        }
    }
   //  top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int top(){
        if(size ==0){
            return -1;
        }else{
            return stack[size-1];
        }
    }

}