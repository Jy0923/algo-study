import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int line;
	static int[][] arr;
	static boolean[] isUsed;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		StringTokenizer st;

		arr = new int[n + 1][n + 1];
		isUsed = new boolean[n + 1];
		answer = 0;

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;

		}

		Queue<Integer> queue = new LinkedList();
		isUsed[1] = true;
		queue.offer(1);

		while (!queue.isEmpty()) {
			int target = queue.poll();
			for (int i = 0; i < n + 1; i++) {
				if (arr[target][i] == 1) {
					if (!isUsed[i]) {
						isUsed[i] = true;
						queue.add(i);
						answer++;
					}

				}

			}

		}

		System.out.println(answer);
	}
}
