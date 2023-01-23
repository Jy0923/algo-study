import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Th_10473 {

    static class Node implements Comparable<Node>{
        int vex;
        double time;

        public Node(int vex, double time) {
            this.vex = vex;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time < o.time)
                return -1;
            return 1;
        }
    }

    static ArrayList<Double> xArr;
    static ArrayList<Double> yArr;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //각 위치별 x,y 좌표값
        xArr = new ArrayList<Double>();
        yArr = new ArrayList<Double>();

        //시작지점, 도착지점 추가
        addList(sc,2);

        int N = sc.nextInt(); // 대포 수

        //대포 위치 추가
        addList(sc, N);

        //노드 담을 리스트
        list = new ArrayList<>();

        //리스트 초기화
        for(int i=0; i<N+2; i++)
            list.add(new ArrayList<>());

        //각 노드끼리 연결하는 간선 만들기
        makeEdge();

        //시작지점부터 각 위치까지 최소시간
        double[] minTime = new double[N+2];
        
        //각 정점까지 걸리는 시간의 최대는 약223초
        //따라서 250으로 값 채우기
        Arrays.fill(minTime,250);
        
        //방문 체크 배열
        boolean[] ch = new boolean[N+2];

        //도착지점까지 최소시간 구하기
        dijkstra(minTime, ch);

        System.out.println(minTime[1]);
    }

    //리스트에 좌표 추가
    private static void addList(Scanner sc, int cnt) {
        for(int i=0; i<cnt; i++) {
            xArr.add(sc.nextDouble());
            yArr.add(sc.nextDouble());
        }
    }

    //각 노드끼리 연결하는 간선 만들기
    private static void makeEdge() {
        for(int i=0; i<list.size(); i++) {
            if(i == 1) continue;

            for(int j=0; j<list.size(); j++) {
                double dis = getDis(i, j);
                double time = 0;

                //시작지점인 경우
                if(i == 0) {

                    //대포가 없으니까
                    //초속 5m/s
                    list.get(i).add(new Node(j, dis / 5));
                } else {
                    //대포로 쏘고 더 간만큼 걸어오기
                    if (dis <= 50 && dis > 30)
                        time = Math.abs(dis - 50) / 5 + 2;
                    
                    //그냥 걸어가기
                    else if (dis < 30)
                        time = dis / 5;
                    
                    //대포로 쏘고 부족한만큼 걸어가기
                    else if (dis > 50)
                        time = (dis - 50) / 5 + 2;

                    list.get(i).add(new Node(j, time));
                }
            }
        }
    }

    // 정점간의 거리 구하기
    static double getDis(int i, int j) {
        double a = Math.abs(xArr.get(i) - xArr.get(j)); // x좌표끼리의 차
        double b = Math.abs(yArr.get(i) - yArr.get(j)); // y좌표끼리의 차

        //피타고라스의 정리
        return  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    //다익스트라...
    private static void dijkstra(double[] minTime, boolean[] ch) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(0, 0));

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int curVex = cur.vex;

            if(ch[curVex]) continue;

            ch[curVex] = true;

            minTime[curVex] = Math.min(minTime[curVex], cur.time);

            if(ch[1]) break;

            for(Node e : list.get(curVex)) {
                if(ch[e.vex]) continue;
                que.add(new Node(e.vex, cur.time + e.time));
            }
        }
    }
}