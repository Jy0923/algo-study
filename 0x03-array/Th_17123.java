import java.io.*;
import java.util.StringTokenizer;

public class Th_17123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 배열의 크기 N*N
            int M = Integer.parseInt(st.nextToken()); // 연산 횟수

            int[][] map = new int[N + 1][N + 1];

            // 배열 값 할당
            for (int r=1; r<=N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c=1; c<=N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());

                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                //연산 수행
                cal(r1, c1, r2, c2, v, map);
            }

            // 행의 합 bw에 추가
            printSum(N, map, bw, true);
            // 열의 합 bw에 추가
            printSum(N, map, bw, false);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /*
     * (r1, c1)부터 (r2, c2)까지 사각형 영역에 속한 arr[r, c]의 값에 v 더하기
     */
    static void cal(int r1, int c1, int r2, int c2, int v, int[][] map) {
        for(int r=r1; r<=r2; r++) {
            for(int c=c1; c<=c2; c++) {
                map[r][c] += v;
            }
        }
    }

    /*
     * 각 행(혹은 열)의 합 한줄에 출력(bw에 추가)
     */
    static void printSum(int N, int[][] map, BufferedWriter bw, boolean isRow) throws IOException {
        for (int r=1; r<=N; r++) {
            int sum = 0;
            for (int c=1; c<=N; c++) {
                if(isRow)
                    sum += map[r][c];
                else
                    sum += map[c][r];
            }
            bw.write(sum +" ");
        }
        bw.write("\n");
    }
}
