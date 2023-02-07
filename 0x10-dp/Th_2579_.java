import java.util.Scanner;

//백준 실버3 계단 오르기
public class Th_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] stair = new int[N];
        int[] maxScore = new int[N];

        for(int i=0; i<N; i++) {
            stair[i] = sc.nextInt();
        }

        if(N == 1) {
            System.out.println(stair[0]);
            return;
        }

        if(N == 2) {
            System.out.println(stair[0] + stair[1]);
            return;
        }

        if(N == 3) {
            System.out.println(Math.max(stair[0], stair[1]) + stair[2]);
            return;
        }

        maxScore[0] = stair[0];
        maxScore[1] = stair[0] + stair[1];
        maxScore[2] = Math.max(stair[0], stair[1]) + stair[2];

        for(int i=3; i<N; i++) {
            maxScore[i] = Math.max(stair[i-1] + maxScore[i-3], maxScore[i-2]) + stair[i];
        }

        System.out.println(maxScore[N-1]);
    }
}