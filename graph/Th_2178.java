import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int N = Integer.parseInt(tmp[0]); // row
        int M = Integer.parseInt(tmp[1]); // column

        int[][] maze = new int[N][M]; //미로 배열
        boolean[][] visited = new boolean[N][M]; //이미 방문한 곳인지 확인
        
        for(int r=0; r<N; r++) {
            String row = br.readLine();

            for(int c=0; c<M; c++) {
                maze[r][c] = row.charAt(c) - '0';
            }
        }

        BFS(N, M, maze, visited, new Coor(0, 0, 1));

        System.out.println(min);
    }

    private static class Coor{
        int r;
        int c;
        int cnt;

        public Coor(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void BFS(int N, int M, int[][] maze, boolean[][] visited, Coor c) {
        Queue<Coor> q = new LinkedList<>();
        q.offer(c);

        while(!q.isEmpty()) {
            Coor now = q.poll();

            //미로 탈출시
            if(now.r == N-1 && now.c == M-1) {
                min = Math.min(min, now.cnt);
                continue;
            }

            //상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                // 배열을 벗어난 경우
                if(nr < 0 || nr == N || nc < 0 || nc == M)
                    continue;

                //이동할 수 없는 칸일 경우
                if(maze[nr][nc] == 0)
                    continue;
                
                //이미 방문한 칸일 경우
                if(visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                q.offer(new Coor(nr,nc,now.cnt+1));
            }
        }
    }
}