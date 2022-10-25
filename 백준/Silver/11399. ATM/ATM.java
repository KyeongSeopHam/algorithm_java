
import java.util.Scanner;

/**
 * <데이터 3,1,4,3,2> (분)
 * [1,2,3,4,5] 순서
 * 3 4  8  11  13  (걸리는 시간(분)) => 39
 * =======================
 * [2,5,1,4,3] 순서
 * 1,3,6,9,13 =>32
 * <p>
 * 현실적으로 줄을 서서 기다리면 똑같이 15분이지만 ㅋㅎ
 * 문제를내기위해선 이렇게 낸거같다.
 * <p>
 * <p>
 * !!!!삽입정렬을 이용해서풀어보자.!!!
 * 3 1 4 3 2
 * 시프트
 * 1 3 4 3 2
 * 1 3 4 3 2
 * 1 3 3 4 2 다한칸씩 -> 이동
 * 1 2 3 3 4
 * <p>
 * A[] 정렬된배열
 * 1 2 3 3 4
 * ->
 * S[] 합배열
 * 1 3 6 9 13
 * <p>
 * EX) S[3] = 9인데 애를 어캐구하냐
 * S[2]= A[0] A[1]+A[2]
 * s[3-1] + A[3] = 6+3 =9
 * S[i-1] +A[i] = 6+3 =9
 * <p>
 * <p>
 * for(i:N만큼 반복하기){
 * for(j: i-1 ~0까지 뒤에서부터 반복하기) {
 * 현재 범위에서 삽입 위치 찾기 비교해서
 * }
 * for( j : i~ insert_point +1까지 뒤에서부터 반복하기) {
 * <p>
 * 삽입을 위해 삽입 위치에서 i까지 데이터를 한카씩 뒤로 밀기
 * }
 * 삽입 위치에 현재 데이터 삽입하기
 * }
 * <p>
 * <p>
 * }
 */


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N]; //원본배열
        int[] S = new int[N]; // 합배열

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) {

            int insert_point = i;  // ex) 3 2 1  2뽑아서 앞에꺼랑비교할거니까 (인덱스저장)
            int insert_value = A[i]; // 삽입시킬애 값저장

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) { // 비교했을떄 1번인덱스값이 더크면 0번인덱스랑 교체할준비
                    insert_point = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_point = 0;
                }
            }

            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }
            A[insert_point] = insert_value;

        }

        S[0] = A[0]; // 합배열 생성하기

        for(int i=1; i<N; i++){
            S[i] = A[i]+S[i-1];
        }
        int sum=0; //합배열총합
        for(int i=0; i<N; i++){
            sum = sum + S[i];
        }
        System.out.println(sum);

    }

}

