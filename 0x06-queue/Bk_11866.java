package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bk_11866 {

	static int N;
	static int K;
	static Queue<Integer> Q = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			Q.offer(i);
		}

		sb.append("<");

		int cnt = 0;
		while (Q.size() != 1) {
			if (cnt == K - 1) {
				sb.append(Q.poll() + ", ");
				cnt = 0;
				continue;
			} else {
				Q.add(Q.poll());
				cnt++;
			}
		}

		sb.append(Q.peek() + ">");
		System.out.println(sb);

	}

}
