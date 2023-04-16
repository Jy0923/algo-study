import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Th_1238 {
    static ArrayList<ArrayList<Edge>> list;

    static int[] homeToX;
    static int[] XToHome;
    static int N;
    static int M;
    static int X;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String[] tmp = br.readLine().split( " ");
        N = Integer.parseInt(tmp[0]); //학생 수
        M = Integer.parseInt(tmp[1]); //도로 수
        X = Integer.parseInt(tmp[2]); //파티 지점
        max = Integer.MIN_VALUE; //가장 오래 걸리는 학생의 시간

        homeToX = new int[N+1]; //각 마을부터 X까지 최소시간
        XToHome = new int[N+1]; //X부터 각 마을까지의 최소시간

        //간선 정보 저장할 list
        list = new ArrayList<>();

        //list 초기화
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<Edge>());
        }

        //간선 정보 저장
        for(int i=0; i<M; i++) {
            tmp = br.readLine().split( " ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int time = Integer.parseInt(tmp[2]);

            list.get(from).add(new Edge(to, time));
        }

        for(int i=1; i<=N; i++) {
            boolean[] ch = new boolean[N+1]; //방문 여부 확인
            int[] time = new int[N+1]; //각 마을 최소시간
            Arrays.fill(time, Integer.MAX_VALUE);

            // i부터 X까지의 최소 시간 구하기
            dijkstra(i, ch, time);

            // i가 X일 경우
            if(i == X) XToHome = Arrays.copyOf(time, time.length);
        }

        // 가장 오래 걸리는 시간 구하기
        getMax();

        System.out.println(max);
    }

    static class Edge implements Comparable<Edge>{
        int vex, time;

        public Edge(int vex, int time) {
            this.vex = vex;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }

    private static void getMax() {
        for(int i=1; i<=N; i++){
            if(i == X) continue;
            int totalTime = homeToX[i] + XToHome[i];
            max = Math.max(max, totalTime);
        }
    }

    private static void dijkstra(int i, boolean[] ch, int[] time) {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(i, 0));

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            // 방문한 마을일 경우
            if(ch[cur.vex]) continue;

            // 방문 체크
            ch[cur.vex] = true;

            // 최소 시간 갱신
            time[cur.vex] = Math.min(time[cur.vex], cur.time);

            // i가 X가 아닌경우
            if(i != X) {
                // X까지의 최소 시간이 구해지면 break
                if(ch[X]) {
                    homeToX[i] = time[X];
                    break;
                }
            }

            // 현재 마을에서 방문 가능한 마을 큐에 추가
            for (Edge e : list.get(cur.vex)) {
                // 이미 방문한 곳이면 패스
                if(ch[e.vex]) continue;
                que.offer(new Edge(e.vex, e.time + time[cur.vex]));
            }
        }
    }
}