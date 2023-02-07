import java.util.Scanner;

public class Th_1463{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[3000001];
        num[2] = 1;
        num[3] = 1;

        for(int i=4; i<=N; i++) {
            num[i] = Integer.MAX_VALUE;
        }

        for(int i=2; i<=N; i++) {
            if(num[i] == Integer.MAX_VALUE) continue;

            num[i+1] = Math.min(num[i+1], num[i] + 1);
            num[i*2] = Math.min(num[i*2], num[i] + 1);
            num[i*3] = Math.min(num[i*3], num[i] + 1);
        }

        System.out.println(num[N]);
    }
}