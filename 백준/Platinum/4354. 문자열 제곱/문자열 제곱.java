import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String S = br.readLine();
                if (S.equals(".")) return;

                // KMP 알고리즘 실패함수 테이블
                int[] pi = makeTable(S);

                // 실패함수의 마지막 원소 값
                int piVal = pi[S.length() - 1];

                // 반복되는 횟수(거듭제곱 크기)
                if(S.length() % (S.length() - piVal) != 0)
                    System.out.println(1);
                else
                    System.out.println(S.length() / (S.length() - piVal));
            }
        }

        private static int[] makeTable(String patternStr) {
            // 테이블 배열 생성
            char[] pattern = patternStr.toCharArray();
            int pLen = pattern.length;
            int[] table = new int[pLen];

            int j = 0;
            for(int i=1; i<pLen; i++) {
                while(j>0 && pattern[i] != pattern[j]) {
                    j = table[j-1];
                }
                if(pattern[i] == pattern[j]) {
                    table[i] = ++j;
                }
            }
            return table;
        }

    }

