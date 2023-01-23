import java.util.PriorityQueue;
import java.util.Scanner;

public class Th_4485 {
    static class Coor implements Comparable<Coor>{
        int x, y, cost;

        public Coor(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Coor o) {
            return this.cost - o.cost;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int tc = 0;

        while(N != 0) {
            tc++;

            int[][] cave = new int[N][N];
            int[][] min = new int[N][N]; //위치별 최솟값

            // 값 할당
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    cave[r][c] = sc.nextInt();
                    min[r][c] = Integer.MAX_VALUE;
                }
            }

            //초기값
            min[0][0] = cave[0][0];

            PriorityQueue<Coor> que = new PriorityQueue<>();

            //시작 지점
            que.offer(new Coor(0, 0, cave[0][0]));

            while (!que.isEmpty()) {
                Coor cur = que.poll();

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    //배열 벗어났는지 확인
                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    
                    if (min[nx][ny] > min[cur.x][cur.y] + cave[nx][ny]) {
                        min[nx][ny] = min[cur.x][cur.y] + cave[nx][ny];
                        que.offer(new Coor(nx, ny, min[nx][ny]));
                    }
                }
            }

            System.out.printf("Problem %d: %d\n", tc, min[N-1][N-1]);
            N=sc.nextInt();
        }
    }
}