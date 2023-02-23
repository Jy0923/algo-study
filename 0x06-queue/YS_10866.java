import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 100005;
	static int[] deque = new int[2 * max + 1];
	static int head = max;
	static int tail = max;

	public static void push_front(int x) {
		deque[--head] = x;
	}

	public static void push_back(int x) {
		deque[++tail] = x;
	}

	public static int pop_front() {
		if (head == max) {
			if (tail == max) {
				return -1;
			} else {
				int temp = deque[max + 1];
				for (int i = 0; i < tail - max; i++) {
					deque[max + 1 + i] = deque[max + 2 + i];
				}
				tail--;
				
				
				return temp;
			}
		} else {
			return deque[head++];
		}
	}
	public static int pop_back() {
		if (tail == max) {
			if (head == max) {
				return -1;
			} else {
				int temp = deque[max - 1];
				for (int i = 0; i < max - head; i++) {
					deque[max - 1 - i] = deque[max - 2 - i];
				}
				head++;
				return temp;
			}
		} else {
			return deque[tail--];
		}
	}

	public static int size() {
		return tail - head;
	}

	public static int empty() {
		if (head == tail) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (head == max) {
			if (tail == max) {
				return -1;
			} else {
				return deque[max + 1];
			}
		} else {
			return deque[head];
		}
	}

	public static int back() {
		if (tail == max) {
			if (head == max) {
				return -1;
			} else {
				return deque[max - 1];
			}
		} else {
			return deque[tail];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String order;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			switch (order) {
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				continue;
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				continue;

			case "pop_front":
				System.out.println(pop_front());
				continue;

			case "pop_back":
				System.out.println(pop_back());
				continue;

			case "size":
				System.out.println(size());
				continue;

			case "empty":
				System.out.println(empty());
				continue;

			case "front":
				System.out.println(front());
				continue;

			case "back":
				System.out.println(back());
				continue;

			}
		}

	}
}
