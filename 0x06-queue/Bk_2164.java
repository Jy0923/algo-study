package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 수
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> Q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			Q.add(i);
		}

		while (Q.size() != 1) {
			Q.remove();
			Q.add(Q.poll());
		}

		System.out.println(Q.peek());

	}

}
