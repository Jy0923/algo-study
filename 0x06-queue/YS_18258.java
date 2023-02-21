import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MX = 2000005;

	static int[] data;
	static int head = 0;
	static int tail = 0;

	public static void push(int x) {
		data[tail++] = x;
	}

	public static int pop() {
		if (tail == head) {
			return -1;
		} else {
			return data[head++];
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

	public static int back() {
		if (head == tail) {
			return -1;
		} else {
			return data[tail - 1];

		}
	}

	public static int front() {
		if (head == tail) {
			return -1;
		} else {

			return data[head];
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer order;
		int num;
		data = new int[MX];
		String test;

		for (int i = 0; i < n; i++) {
			order = new StringTokenizer(br.readLine(), " ");
			test = order.nextToken();
			if (test.equals("pop")) {
				sb.append(pop() + "\n");
			} else if (test.equals("front")) {
				sb.append(front() + "\n");
			} else if (test.equals("back")) {
				sb.append(back() + "\n");
			} else if (test.equals("size")) {
				sb.append(size() + "\n");
			} else if (test.equals("empty")) {
				sb.append(empty() + "\n");
			} else {
				num = Integer.parseInt(order.nextToken());
				push(num);
			}
		}
		System.out.println(sb);

	}
}
