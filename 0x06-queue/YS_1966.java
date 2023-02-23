import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max = 1000001;
	static int[] queue;
	static int front;
	static int rear;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;
		int m;
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			queue = new int[max];
			front = 0;
			rear = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int mark = m;
			for (int j = 0; j < n; j++) {

				enQueue(Integer.parseInt(st.nextToken()));

			}

			boolean bigger;
			int cnt = 0;

			while (size() != 0) {
				bigger = false;
				for (int j = 0; j < size(); j++) {
					if (peek() < queue[j]) {
						bigger = true;
						break;
					}
				}

				if (mark == 0) {
					if (bigger) {
						enQueue(deQueue());
						mark = rear - 1;
						continue;
					} else {
						cnt++;
						System.out.println(cnt);
						break;
					}
				}

				if (bigger) {
					enQueue(deQueue());
					mark--;
				} else {
					deQueue();
					cnt++;
					mark--;
				}

			}

		}

	}

	private static void enQueue(int deQueue) {

		queue[rear++] = deQueue;

	}

	private static int deQueue() {
		int temp = queue[front];
		rear--;
		for (int i = 0; i < rear; i++) {
			queue[i] = queue[i + 1];
		}

		return temp;
	}

	private static int peek() {
		return queue[front];
	}

	private static int size() {
		return rear - front;
	}
}
