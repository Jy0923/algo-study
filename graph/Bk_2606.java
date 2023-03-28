package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_2606 {

	static BufferedReader br;
	static StringBuilder sb;

	static int computers, edges;
	static boolean[] visited = null;
	static ArrayList<ArrayList<Integer>> list;

	// 바이러스에 걸리는 컴퓨터의 수
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		computers = Integer.parseInt(br.readLine());
		edges = Integer.parseInt(br.readLine());

		// 리스트 생성
		list = new ArrayList<>();
		for (int i = 0; i <= computers; i++) {
			// 해당 정점의 인접 정점 리스트
			list.add(new ArrayList<Integer>());
		}

		String[] input = null;
		int vertex = 0, graph = 0;
		for (int i = 0; i < edges; i++) {
			input = br.readLine().split(" ");

			vertex = Integer.parseInt(input[0]);
			graph = Integer.parseInt(input[1]);

			// 해당 정점이 가진 인접정점리스트 기록
			// 양방향 간선
			list.get(vertex).add(graph);
			list.get(graph).add(vertex);
		}

		visited = new boolean[computers + 1];

		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(1);
		visited[1] = true;

		int cur = 0;
		List<Integer> vList = null;
		while (!Q.isEmpty()) {
			cur = Q.poll();
			vList = list.get(cur);

			for (int data : vList) {
				if (visited[data])
					continue;
				visited[data] = true;
				cnt++;
				Q.add(data);
			}
		}

		System.out.println(cnt);

	}
}
