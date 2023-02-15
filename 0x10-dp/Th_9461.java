import java.util.Scanner;

public class Th_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++) {
            int N = sc.nextInt();
            long[] dy = new long[N];

            for(int i=0; i<N; i++) {
                if(i <= 2) {
                    dy[i] = 1;
                    continue;
                }

                if(2 < i && i <= 4) {
                    dy[i] = 2;
                    continue;
                }

                dy[i] = dy[i-1] + dy[i-5];
            }

            System.out.println(dy[N-1]);
        }
    }
}
