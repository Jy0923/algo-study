package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1956_운동 {

    private final static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read;

        read = br.readLine().split(" ");
        int V = Integer.parseInt(read[0]);
        int E = Integer.parseInt(read[1]);

        int[][] disArr = new int[V+1][V+1];

        for(int i=1; i<=V; i++) {
            Arrays.fill(disArr[i],INF);
        }

        for(int i=0; i<E; i++) {
            read = br.readLine().split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);
            int c = Integer.parseInt(read[2]);
            disArr[a][b] = c;
        }

        //거쳐갈 정점
        for(int i=1; i<=V; i++) {
            //출발 정점
            for(int j=1; j<=V; j++) {
                //도착 정점
                for(int k=1; k<=V; k++) {
                    if(i==j || k==j || j==k) continue;
                    disArr[j][k] = Math.min(disArr[j][k], disArr[j][i] + disArr[i][k]);
                }
            }
        }

        int min = INF;
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                int dis = disArr[i][j] + disArr[j][i];
                if(dis >= INF) continue;
                min = Math.min(min, dis);
            }
        }

        System.out.println((min == INF)? -1 : min);
    }
}
