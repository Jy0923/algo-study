import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2206_벽부수고이동하기 {

    static final int[] DX = {0,1,0,-1};
    static final int[] DY = {1,0,-1,0};

    static int N,M,min;
    static int[][] map;
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read;

        read = br.readLine().split(" ");
        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);
        
        map = new int[N+1][M+1];
        isVisited = new boolean[N+1][M+1][2];
        min = Integer.MAX_VALUE;

        String readLine;
        for(int i=1; i<=N; i++) {
            readLine = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = readLine.charAt(j-1)-'0';
            }
        }

        getMinDistance();

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void getMinDistance() {
        Queue<Coor> que = new LinkedList<>();
        que.offer(new Coor(1,1,1,true));
        isVisited[1][1][0] = true;
        isVisited[1][1][1] = true;

        while(!que.isEmpty()) {
            Coor cur = que.poll();

            if(cur.x == N && cur.y == M) {
                min = Math.min(min, cur.cnt);
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];

                //맵을 벗어나면 건너뛰기
                if(nx<1 || ny<1 || nx>N || ny>M)
                    continue;

                //벽인 경우
                if(map[nx][ny] == 1) {
                    if(cur.crush) {
                        isVisited[nx][ny][1] = true;
                        que.offer(new Coor(nx, ny, cur.cnt + 1, false));
                        continue;
                    }
                }

                //이동할 수 있는 곳인 경우
                if(map[nx][ny] == 0) {
                    if(cur.crush && !isVisited[nx][ny][0]) {
                        isVisited[nx][ny][0] = true;
                        que.offer(new Coor(nx, ny, cur.cnt + 1, true));
                        continue;
                    }

                    if(!cur.crush && !isVisited[nx][ny][1]) {
                        isVisited[nx][ny][1] = true;
                        que.offer(new Coor(nx, ny, cur.cnt + 1, false));
                        continue;
                    }
                }
            }
        }

    }

    private static class Coor{
        int x,y,cnt;
        boolean crush;

        public Coor(int x, int y, int cnt, boolean crush) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crush = crush;
        }
    }
}
