import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> deque;

	static int cnt;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		deque = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			deque.offer(i);
		}

		for (int element : arr) {
			find(element);
		}

		System.out.println(cnt);

	}

	public static void find(int x) {
		int idx = ((LinkedList<Integer>) deque).indexOf(x);

		if (idx == 0) {
			deque.removeFirst();

		} else if (deque.size() % 2 == 0) {
			if (idx <= (deque.size() / 2) - 1) {
				for (int i = 0; i < idx; i++) {

					deque.addLast(deque.pollFirst());
					cnt++;
				}
				deque.removeFirst();

			} else {
				for (int i = idx; i < deque.size(); i++) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
				deque.removeFirst();

			}
		} else if (deque.size() % 2 == 1) {
			if (idx <= (deque.size() / 2)) {
				for (int i = 0; i < idx; i++) {

					deque.addLast(deque.pollFirst());
					cnt++;
				}
				deque.removeFirst();
			} else {
				for (int i = idx; i < deque.size(); i++) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
				deque.removeFirst();
			}
		}

	}
}
