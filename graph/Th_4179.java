package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {

    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    static int row;
    static int col;

    static Coor jihun;

    static int minTime = Integer.MAX_VALUE;

    static Queue<Coor> fireQue = new LinkedList<>();

    static char[][] maze;
    static boolean[][] isVisited;
    static int[][] fireArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        maze = new char[row][col];
        isVisited = new boolean[row][col];
        fireArr = new int[row][col];
        for(int i=0; i<row; i++) {
            Arrays.fill(fireArr[i], -1);
        }

        String read;
        for(int i=0; i<row; i++) {
            read = br.readLine();
            for(int j=0; j<col; j++) {
                maze[i][j] = read.charAt(j);

                if(maze[i][j] == 'J') jihun = new Coor(i,j,0);
                if(maze[i][j] == 'F') {
                    fireArr[i][j] = 0;
                    fireQue.offer(new Coor(i,j,0));
                }
            }
        }

        fireSpread();
        getOut();

        if(minTime == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(minTime);
        }
    }

    private static void fireSpread() {
        while(!fireQue.isEmpty()) {
            Coor cur = fireQue.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];

                if(nx<0 || ny<0 || nx>=row || ny>=col)
                    continue;

                if(maze[nx][ny] == '#' || fireArr[nx][ny] != -1)
                    continue;

                fireArr[nx][ny] = cur.time + 1;
                fireQue.offer(new Coor(nx,ny,fireArr[nx][ny]));
            }
        }
    }

    private static void getOut() {
        Queue<Coor> que = new LinkedList<>();
        isVisited[jihun.x][jihun.y] = true;
        que.offer(jihun);

        while(!que.isEmpty()) {
            Coor cur = que.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + DX[i];
                int ny = cur.y + DY[i];

                if(nx<0 || ny<0 || nx>=row || ny>=col) {
                    minTime = Math.min(minTime, cur.time+1);
                    return;
                }

                if (maze[nx][ny] == '#' || (fireArr[nx][ny] != -1 && cur.time + 1 >= fireArr[nx][ny]) || isVisited[nx][ny])
                    continue;

                isVisited[nx][ny] = true;
                que.offer(new Coor(nx, ny, cur.time + 1));
            }
        }
    }

    private static class Coor {
        int x;
        int y;
        int time;
        public Coor(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
