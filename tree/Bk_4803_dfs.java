package tree;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bk_4803_dfs {

	static int N, M;

	static StringBuilder sb;
	static BufferedReader br;

	static boolean[] visited;

	static List<Integer>[] edges;


	static int tc = 1;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true) {
			String[] input = br.readLine().split(" ");

			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			if (N == 0 && M == 0)
				break;

			visited = new boolean[N + 1];
			edges = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			int a = 0, b = 0;
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);

				edges[a].add(b);
				edges[b].add(a);
			}
			
			solution();

			tc++;
		}

		System.out.println(sb);

	}

	static int vertex;
	static int edge;

	static void solution() {
		int treeCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			vertex = 0;
			edge = 0;
			dfs(i);

			if (edge == (vertex - 1) * 2)
				treeCnt++;
		}
		if (treeCnt > 1)
			sb.append("Case " + tc + ": A forest of " + treeCnt + " trees.\n");
		else if (treeCnt == 1)
			sb.append("Case " + tc + ": There is one tree.\n");
		else
			sb.append("Case " + tc + ": No trees.\n");
	}

	private static void dfs(int i) {
		vertex++;
		edge += edges[i].size();
		visited[i] = true;
		
		for(int linkedNode : edges[i]) {
			if(visited[linkedNode]) continue;
			dfs(linkedNode);
		}

	}
}
