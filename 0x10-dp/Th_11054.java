import java.util.Scanner;

public class Th_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] num = new int[N];
        int max = 1; //전체 최댓값

        int[] up = new int[N]; // 증가하는 수열 최대값
        int[] bitonic = new int[N]; // 바이토닉 수열 최댓값

        String[] read = sc.nextLine().split(" ");

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(read[i]);
            up[i] = 1;
            bitonic[i] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=i-1; j>=0; j--) {
                //이전수가 현재수보다 작을경우
                //이전수의 증가수열값 +1을 증가수열값에 넣음
                if(num[i] > num[j]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }

                //이전수가 현재수보다 클경우
                //1. 이전수의 증가수열값 +1 을 바이토닉값에 넣음
                //2. 이전수의 바이토닉값 +1 을 바이토닉값에 넣음
                //1. 2. 비교해서 최댓값
                if(num[i] < num[j]) {
                    bitonic[i] = Math.max(Math.max(bitonic[i], up[j] + 1), bitonic[j] + 1);
                }

                //현재수의 증가수열값, 바이토닉값 비교
                max = Math.max(Math.max(up[i], bitonic[i]),max);
            }
        }

        System.out.print(max);
    }
}
