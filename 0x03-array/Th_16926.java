import java.io.*;
import java.util.StringTokenizer;

public class Th_16926 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 배열 세로
        M = Integer.parseInt(st.nextToken());   // 배열 가로
        int R = Integer.parseInt(st.nextToken());   // 회전수

        int[][] arr = new int[N][M];

        //배열 할당
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(N, M);

        for(int i=0; i<R; i++) {
            for (int idx=0; idx<cnt/2; idx++) {
                // 배열 회전
                rotate(arr, idx);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void rotate(int[][] arr, int idx) {
        int save = arr[idx][idx];
        int tmp;
        int x = idx;
        int y = idx;

        // 하 우 상 좌 순으로 이동
        for(int i=0; i<4; i++) {
            while (true) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //라인을 벗어나면 break;
                if(idx>nx || nx==N-idx ||
                        idx>ny || ny==M-idx) break;

                //값 바꾸기
                tmp = arr[nx][ny];
                arr[nx][ny] = save;
                save = tmp;

                //좌표 이동
                x = nx;
                y = ny;
            }
        }
    }
}
