package brute_force;

import java.util.Scanner;

public class Bk_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] height = new int[N];
		int[] weight = new int[N];

		for (int i = 0; i < N; i++) {
			height[i] = sc.nextInt();
			weight[i] = sc.nextInt();
		}

		int result[] = new int[N];
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (height[i] < height[j] && weight[i] < weight[j])
					cnt++;
			}
			result[i] = cnt;
		}

		for(int i:result)
			System.out.print(i + " ");
	}

}
