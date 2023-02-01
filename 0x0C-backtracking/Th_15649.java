import java.util.Scanner;

public class Th_15649 {
    static int N; //1부터 N까지 자연수
    static int M; //수열 길이
    static int[] arr; //수열
    static boolean[] visited; //사용 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visited = new boolean[N+1];

        tracking(0);

        System.out.println(sb);
    }

    private static void tracking(int cnt) {
        //수열 완성
        if(cnt == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            //사용하지 않은 수
            if(!visited[i]) {
                arr[cnt] = i;
                //사용 체크
                visited[i] = true;
                tracking(cnt+1);
                //사용 체크 취소
                visited[i] = false;
            }
        }
    }
}