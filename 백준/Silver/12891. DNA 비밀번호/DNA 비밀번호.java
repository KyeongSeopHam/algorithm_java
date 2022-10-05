
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int checkSecret; // DNA문자 4개조건을위한 변수 (스태틱)
    static int check_ACGT_MinNum[]; //  DNA문자를 위한 4개문자를 위한 배열
    static int myArr[]; // 슬라이딩구간 [부분문자열]에 대한 현재 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int DNA_Length = Integer.parseInt(st.nextToken());      // DNA문자열의 길이
        int DNA_SubSetLength = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        int Result = 0; // 결과값
        char[] DNA_Total_Char = new char[DNA_Length]; // 2번째에서 받는 문자처리를 위한 char[]
        DNA_Total_Char = br.readLine().toCharArray();  // DNA 문자열을 받을건데 -> 한줄읽어서.toCharArray()로 넣어주기
        myArr = new int[4]; // 부분문자열에서 ACGT의 카운트저장하기위한 배열  (DNA문자 4개조건과 비교하기위해서)
        check_ACGT_MinNum = new int[4]; // 부분 문자열에 포함돼어야 할 A,C,G,T의 최소 갯수
        checkSecret = 0; // DNA문자 4개조건을위한 변수 (스태틱)


        st = new StringTokenizer(br.readLine()); // 3번쨰줄

        for (int i = 0; i < 4; i++) {
            check_ACGT_MinNum[i] = Integer.parseInt(st.nextToken()); // 3번째줄 ex) 2 0 1 1 (부분문자열 최소갯수)
            // 예외처리
            if (check_ACGT_MinNum[i] == 0) checkSecret++;
        }
        for(int i=0; i<DNA_SubSetLength; i++) Add(DNA_Total_Char[i]); // 첫번째 DNA_SubSetLength 부분 문자열 처리부분

        if(checkSecret==4) Result++;


        // 슬라이딩 윈도우 처리 부분

        for(int i=DNA_SubSetLength; i<DNA_Length; i++){

            int j= i-DNA_SubSetLength;
            Add(DNA_Total_Char[i]);
            Remove(DNA_Total_Char[j]);
            if(checkSecret==4) Result++;


        }

        System.out.println(Result);
        br.close();


    }

    private static void Add(char c) {
        switch (c){
            case 'A': myArr[0]++; if(myArr[0] == check_ACGT_MinNum[0]) checkSecret++; break;
            case 'C': myArr[1]++; if(myArr[1] == check_ACGT_MinNum[1]) checkSecret++; break;
            case 'G': myArr[2]++; if(myArr[2] == check_ACGT_MinNum[2]) checkSecret++; break;
            case 'T': myArr[3]++; if(myArr[3] == check_ACGT_MinNum[3]) checkSecret++; break;
        }
    }
    private static void Remove(char c) {
        switch (c){
            case 'A':  if(myArr[0] == check_ACGT_MinNum[0]) checkSecret--; myArr[0]--; break;
            case 'C':  if(myArr[1] == check_ACGT_MinNum[1]) checkSecret--; myArr[1]--; break;
            case 'G':  if(myArr[2] == check_ACGT_MinNum[2]) checkSecret--; myArr[2]--; break;
            case 'T':  if(myArr[3] == check_ACGT_MinNum[3]) checkSecret--; myArr[3]--;break;
        }
    }


}
