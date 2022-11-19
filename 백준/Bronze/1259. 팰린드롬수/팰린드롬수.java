import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 /*어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다.
'radar', 'sees'는 팰린드롬이다.

문제에선 숫자로 할거
ex) 121  12421   => ok
ex) 123, 1231    => no

무의미한 0이 앞에 올수없음 
T = N개가주어짐 여러개
1<=99999  
마지막 0오면 종료 
T=yes F=no
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
 
        while (true) { //  트루일동안 계속 돌건데  0입력시탈출조건 
            String str = br.readLine(); // 입력을 스트링 타입으로 받을거고
            boolean chk = true; // 팰린드롬수인지 확인하기위한 boolean변수추가
 
            if(str.equals("0")) break; // 0입력할경우 종료
 
            for (int i = 0; i < str.length()/2; i++) { //절반까지만 짤라서
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)){
                    chk = false;  //if: 같지않다면 false처리
                }                  
            }  // 하나씩 비교할거 끝에있는애랑 첫번쨰애랑 팰린도룸체크
 
            if(chk){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}