package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_11657_타임머신 {

    static final int INF = Integer.MAX_VALUE;
    static int N,M;
    static ArrayList<Edge> edgeList;
    static long[] disArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] read;

        read = br.readLine().split(" ");
        N = Integer.parseInt(read[0]);
        M = Integer.parseInt(read[1]);

        edgeList = new ArrayList<>();

        for(int i=0; i<M; i++) {
            read = br.readLine().split(" ");
            int from = Integer.parseInt(read[0]);
            int to = Integer.parseInt(read[1]);
            int time = Integer.parseInt(read[2]);
            edgeList.add(new Edge(from, to, time));
        }

        StringBuilder sb = new StringBuilder();

        if(!bellmanFord()) sb.append("-1");
        else {
            for(int i = 2; i <= N; i++)
                sb.append(disArr[i] == INF ? "-1\n" : disArr[i] + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean bellmanFord() {
        disArr = new long[N+1];
        Arrays.fill(disArr, INF);
        disArr[1] = 0;
        
        for(int i=0; i<N+1; i++) {
            for(Edge edge : edgeList) {
                if(disArr[edge.from] == INF) continue;
                if(disArr[edge.to] > disArr[edge.from] + edge.time) {
                    disArr[edge.to] = disArr[edge.from] + edge.time;
                    if(i==N) return false;
                }
            }
        }
        return true;
    }

    private static class Edge {
        int from,to;
        long time;

        public Edge(int from, int to, long time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
}
