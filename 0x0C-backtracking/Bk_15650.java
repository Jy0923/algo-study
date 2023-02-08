package backtracking;

import java.util.Scanner;

public class Bk_15650 {

	static int N, M;
	static int[] arr;
	static boolean[] isused;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		isused = new boolean[N + 1];
		backtracking(0, 0);

	}

	static void backtracking(int current, int prev) {

		if (current == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = prev + 1; i <= N; i++) {
			if (!isused[i]) {
				arr[current] = i;
				isused[i] = true;
				backtracking(current + 1, i);
				isused[i] = false;
			}

		}
	}

}
