package baekjoon;

import java.util.*;

public class BOJ_1697_숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subin = sc.nextInt();
        int dongsaeng = sc.nextInt();
        int minTime = 0;

        boolean[] isVisited = new boolean[100_001];
        isVisited[subin] = true;

        Queue<Pos> que = new LinkedList<>();

        que.offer(new Pos(subin, 0));

        while(!que.isEmpty()) {
            Pos cur = que.poll();

            if(cur.now-1>=0 && cur.now-1<100_001 && !isVisited[cur.now-1]) {

                if(cur.now-1 == dongsaeng) {
                    minTime = cur.time+1;
                    break;
                }

                isVisited[cur.now-1] = true;
                que.offer(new Pos(cur.now - 1, cur.time + 1));
            }

            if(cur.now+1>=0 && cur.now+1<100_001 && !isVisited[cur.now+1]) {

                if(cur.now+1 == dongsaeng) {
                    minTime = cur.time+1;
                    break;
                }

                isVisited[cur.now+1] = true;
                que.offer(new Pos(cur.now+1, cur.time+1));
            }

            if(cur.now*2>=0 && cur.now*2<100_001 && !isVisited[cur.now*2]) {

                if(cur.now*2 == dongsaeng) {
                    minTime = cur.time+1;
                    break;
                }

                isVisited[cur.now*2] = true;
                que.offer(new Pos(cur.now*2, cur.time+1));
            }
        }
        System.out.println(minTime);
    }

    private static class Pos{
        int now;
        int time;

        public Pos(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }
}
