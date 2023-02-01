import java.util.Scanner;

public class Th_15650 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N+1];

        tracking(1,0);

        System.out.println(sb);
    }

    private static void tracking(int start, int cnt) {
        //배열 채워지면 리턴
        if(cnt == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            arr[cnt] = i;
            //start + 1 해줘서 다음 반복문은
            //배열에 추가된 수보다 큰 숫자로 시작
            tracking(i+1,cnt+1);
        }
    }
}