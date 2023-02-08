package backtracking;

import java.util.Scanner;

public class Bk_15651 {

	static int n, m;
	static int[] arr;

	static StringBuilder sb = new StringBuilder();

	static void backtracking(int currentIdx) {

		if (currentIdx == m) {
			for (int n : arr) {
				sb.append(n + " ");
			}
			sb.append("\n");
			
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[currentIdx] = i;
			backtracking(currentIdx + 1);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[m];

		backtracking(0);
		
		System.out.println(sb);

	}
}
