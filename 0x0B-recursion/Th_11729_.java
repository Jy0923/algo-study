import java.util.Scanner;

public class Th_11729 {

    static StringBuilder sb = new StringBuilder();
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        hanoi(N, 1, 2, 3);

        System.out.println(cnt + "\n" + sb);
    }

    private static void hanoi(int N, int s, int m, int e) {
        if(N == 0) return;

        hanoi(N - 1, s, e, m);
        move(s,e);
        hanoi(N - 1, m, s, e);
    }

    private static void move(int s, int e) {
        sb.append(s + " " + e +"\n");
        cnt++;
    }
}
