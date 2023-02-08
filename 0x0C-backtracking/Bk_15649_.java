package backtracking;

import java.util.Scanner;

public class Bk_15649_ {

	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	static boolean[] isused;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		isused = new boolean[N + 1];
		backtracking(0);

	}

	static void backtracking(int current) {

		if (current == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!isused[i]) {
				arr[current] = i;
				isused[i] = true;
				backtracking(current + 1);
				isused[i] = false;
			}

		}
	}

}
