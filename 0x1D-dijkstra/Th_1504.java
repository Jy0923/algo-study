import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1504_특정한최단경로 {

    static int numOfVer, numOfEdge, u, v;
    static ArrayList<ArrayList<Edge>> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read;

        read = br.readLine().split(" ");
        numOfVer = Integer.parseInt(read[0]);
        numOfEdge = Integer.parseInt(read[1]);

        edgeList = new ArrayList<>();

        for(int i=0; i<=numOfVer; i++) {
            edgeList.add(new ArrayList<>());
        }

        for(int i=0; i<numOfEdge; i++) {
            read = br.readLine().split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);
            int dis = Integer.parseInt(read[2]);

            edgeList.get(a).add(new Edge(b,dis));
            edgeList.get(b).add(new Edge(a,dis));
        }

        read = br.readLine().split(" ");
        u = Integer.parseInt(read[0]);
        v = Integer.parseInt(read[1]);

        int SUVE = dijkstra(1,u) + dijkstra(u,v) + dijkstra(v,numOfVer);
        int SVUE = dijkstra(1,v) + dijkstra(v,u) + dijkstra(u,numOfVer);

        int minSum = Math.min(SUVE, SVUE);

        if(minSum >= 500_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(minSum);
        }
    }

    private static int dijkstra(int start, int end) {
        boolean[] ch = new boolean[numOfVer+1];
        int[] minArr = new int[numOfVer+1];
        Arrays.fill(minArr, 500_000_000);

        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(start,0));

        while(!que.isEmpty() && !ch[end]) {
            Edge cur = que.poll();
            int curVer = cur.next;
            int curDis = cur.dis;

            if(ch[curVer]) continue;
            ch[curVer] = true;

            if(minArr[curVer] > curDis) {
                minArr[curVer] = curDis;
            }

            for(Edge edge : edgeList.get(curVer)) {
                int nextVer = edge.next;
                int nextDis = curDis + edge.dis;

                if(minArr[nextVer] < nextDis || ch[nextVer]) continue;

                que.offer(new Edge(nextVer, nextDis));
            }
        }
        return minArr[end];
    }

    private static class Edge implements Comparable<Edge>{
        int next, dis;

        public Edge(int next, int dis) {
            this.next = next;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dis - o.dis;
        }
    }
}
