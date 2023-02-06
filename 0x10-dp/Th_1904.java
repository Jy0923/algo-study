import java.util.Scanner;

public class Th_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dy = new int[N+1];

        //1. 타일이 하나 추가되면 이전 타일들에 1 추가 가능
        //2. 마지막이 1로 끝나면 다음 수에 00 추가 가능
        //위 두가지 이유로 피보나치 수열
        dy[0] = 1; dy[1] = 1;
        for(int i=2; i<=N; i++) {
            //값이 너무 커질 수 있으니 계속 15746의 나머지 계산 해주기
            dy[i] = (dy[i-1] + dy[i-2]) %15746;
        }

        System.out.println(dy[N]);
    }
}
