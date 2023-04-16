import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
//	static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
	static ArrayList<Edge> edges;
	
	static class Edge{
		int start, end, cost;
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
     public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		edges = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, c));

			
		}
		boolean cycle = false;
		long[] dist = new long[n+1];
		int inf = Integer.MAX_VALUE;
		Arrays.fill(dist, inf);
		dist[1] = 0;
		
		for (int vertex = 1; vertex <= n; vertex++) {
			for (Edge line : edges) {
				if(dist[line.start] != inf && dist[line.end] > dist[line.start] + line.cost) {
					if(vertex == n) {
						cycle = true;
					}
					dist[line.end] = dist[line.start] + line.cost;
				}
			}
		}

		if(cycle) {
			sb.append(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				if(dist[i] == inf) {
					sb.append("-1\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}
		System.out.println(sb);
		
	}
}
