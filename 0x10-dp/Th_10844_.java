import java.util.*;

public class Th_10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 최대 자릿수
        long[][] dp = new long[N][10]; // 자릿수마다 최댓값 저장할 배열
        final int DIV = 1_000_000_000; // 10억 나눠주기

        //한자리수 0 빼고 1 넣어주기
        for(int i=1; i<10; i++) {
            dp[0][i] = 1;
        }

        //각 자릿수마다
        for(int i=1; i<N; i++) {
            //0~9까지 순회
            for(int j=0; j<10; j++) {
                //마지막 숫자가 0이면
                if(j == 0) {
                    //이전 자릿수 1의 값
                    dp[i][j] = dp[i-1][j+1];
                    continue;
                }

                //마지막 숫자가 9이면
                if(j == 9) {
                    //이전 자릿수 8의 값
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                // 이전 자릿수의 마지막숫자-1 값 + 마지막숫자+1 값
                // 10억 넘으면 안되니까 계속 % 해주기
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIV;
            }
        }

        long answer = 0;

        //마지막 자릿수 모든 숫자 값 더해주고
        // 10억 안넘게 계속 %
        for(int i=0; i<10; i++) {
            answer = (answer + dp[N-1][i]) % DIV;
        }

        System.out.println(answer);
    }
}
