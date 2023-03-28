import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	int n, k;
	int[] map = new int[100001];
	
	public void bfs() {
		int cur;
		int[] next;
		boolean check = false;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		map[n] = 1;
		while (!q.isEmpty()) {
			cur = q.poll();
			next = new int[] {cur - 1, cur + 1, cur * 2};
			for (int nx : next) {
				if (nx < 0 || nx > 100000) {
					continue;
				}
				if (map[nx] > 0) {
					continue;
				}
				q.offer(nx);
				map[nx] = map[cur] + 1;
				if (nx == k) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
		}
	}
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		bfs();
		
		System.out.println(map[k] - 1);
	}
	
	public static void main(String[] args) {
		new Main().solution();
	}
}
