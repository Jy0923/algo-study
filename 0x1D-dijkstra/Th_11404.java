package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11404_플로이드 {

    private final static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] disArr = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(disArr[i],INF);
        }

        for(int i=0; i<m; i++) {
            read = br.readLine().split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);
            int c = Integer.parseInt(read[2]);
            disArr[a][b] = Math.min(disArr[a][b], c);
        }

        //거쳐갈 정점
        for(int i=1; i<=n; i++) {
            //출발 정점
            for(int j=1; j<=n; j++) {
                //도착 정점
                for(int k=1; k<=n; k++) {
                    if(i==j || i==k || j==k) continue;
                    disArr[j][k] = Math.min(disArr[j][k], disArr[j][i] + disArr[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sb.append((disArr[i][j] == INF) ? 0 : disArr[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
