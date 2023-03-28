import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	
	int n, m;
	String[] input;
	int[] visited;
	HashMap<Integer, Integer> ladder = new HashMap<>();
	HashMap<Integer, Integer> snake = new HashMap<>();
	
	public void bfs() {
		LinkedList<Integer> q = new LinkedList<>();
		int cur, nx;
		q.offer(1);
		visited[1] = 1;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 1; i <= 6; i++) {
				nx = cur + i;
				if (nx > 100) {
					continue;
				}
				if (ladder.containsKey(nx)) {
					nx = ladder.get(nx);
				} else if (snake.containsKey(nx)) {
					nx = snake.get(nx);
				}
				if (visited[nx] > 0) {
					continue;
				}
				visited[nx] = visited[cur] + 1;
				q.offer(nx);
				if (nx == 100) {
					return;
				}
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			ladder.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			ladder.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		visited = new int[101];
		bfs();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				
			}
		}
		System.out.println(visited[100] - 1);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
