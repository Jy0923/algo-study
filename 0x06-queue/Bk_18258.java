package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_18258 {

	static int[] dat = new int[2000000];
	static int head = 0, tail = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 주어진 명령의 수
		int N = Integer.parseInt(br.readLine());

		String order = "";
		for (int i = 0; i < N; i++) {
			order = br.readLine();

			if (order.equals("pop")) {
				sb.append(pop() + "\n");
			} else if (order.equals("size")) {
				sb.append(size() + "\n");
			} else if (order.equals("empty")) {
				sb.append(empty() + "\n");
			} else if (order.equals("front")) {
				sb.append(front() + "\n");
			} else if (order.equals("back")) {
				sb.append(back() + "\n");
			} else {
				push(Integer.parseInt(order.split(" ")[1]));
			}
		}
		
		System.out.println(sb);
	}

	// 정수 X를 큐에 넣는 연산
	static void push(int x) {
		dat[tail++] = x;
	}

	// 큐가 비어있으면 1, 아니면 0을 출력
	static int empty() {
		if (head - tail == 0)
			return 1;
		else
			return 0;
	}

	// 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
	static int pop() {
		if (empty() == 1)
			return -1;
		else
			return dat[head++];
	}

	static int size() {
		return tail - head;
	}

	static int front() {
		if (empty() == 1)
			return -1;
		else
			return dat[head];
	}

	static int back() {
		if (empty() == 1)
			return -1;
		else
			return dat[tail - 1];
	}

}
