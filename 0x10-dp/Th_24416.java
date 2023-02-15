import java.util.Scanner;

public class Th_24416 {

    static int fibCnt = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        fib(N);

        System.out.print(fibCnt + " " + (N-2));
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            fibCnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}