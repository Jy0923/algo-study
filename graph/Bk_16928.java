package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Bk_16928 {

	// 사다리와 뱀의 수
	static int N, M;

	static int[] visited;

	static Map<Integer, Integer> snake;
	static Map<Integer, Integer> ladder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		visited = new int[101];
		snake = new HashMap<Integer, Integer>();
		ladder = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			ladder.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			snake.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}


		Queue<Integer> queue = new LinkedList<Integer>();
		visited[1] = 0;
		queue.add(1);

		outer: while (true) {
			int cur = queue.poll();

			for (int i = 1; i <= 6; i++) {

				int newNode = cur + i;

				if (ladder.get(cur + i) != null)
					newNode = ladder.get(cur + i);

				else if (snake.get(cur + i) != null)
					newNode = snake.get(cur + i);

				if (newNode > 100)
					continue;

				if (visited[newNode] != 0)
					continue;

				if (newNode == 100) {
					visited[newNode] = visited[cur] + 1;
					break outer;
				}

				visited[newNode] = visited[cur] + 1;
				queue.add(newNode);

			}
		}

		System.out.println(visited[100]);
	}

}
