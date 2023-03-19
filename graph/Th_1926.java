package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static final int[] DX = {1,0,-1,0};
    static final int[] DY = {0,1,0,-1};

    static int row;
    static int col;

    static int[][] paper;
    static boolean[][] isVisited;

    static int maxSize = 0;
    static int picCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        paper = new int[row][col];
        isVisited = new boolean[row][col];

        for(int i=0; i<row; i++) {
            st = new StringTokenizer(sc.nextLine());
            for(int j=0; j<col; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(paper[i][j] == 0 || isVisited[i][j]) continue;
                findPicture(i,j);
                picCnt++;
            }
        }
        System.out.println(picCnt);
        System.out.println(maxSize);
    }

    private static void findPicture(int r, int c) {
        int size = 0;

        Queue<Coor> que = new LinkedList<>();
        que.offer(new Coor(r,c));
        isVisited[r][c] = true;

        while(!que.isEmpty()) {
            Coor cur = que.poll();
            size++;

            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if(nx<0 || ny<0 || nx>=row || ny>=col)
                    continue;

                if(paper[nx][ny] == 0 || isVisited[nx][ny])
                    continue;

                que.offer(new Coor(nx, ny));
                isVisited[nx][ny] = true;
            }
        }
        maxSize = Math.max(maxSize, size);
    }

    private static class Coor {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
