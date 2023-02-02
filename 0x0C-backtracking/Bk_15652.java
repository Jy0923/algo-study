package backtracking;

import java.util.Scanner;

public class Bk_15652 {
	static int n, m;
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	static void backtracking(int currentIdx, int preNum) {
		if (currentIdx == m) {
			for (int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (preNum > i)
				continue;

			arr[currentIdx] = i;
			backtracking(currentIdx + 1, i);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[m];

		backtracking(0, 0);

		System.out.println(sb);

	}
}
