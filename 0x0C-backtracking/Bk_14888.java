package backtracking;

import java.util.Scanner;

public class Bk_14888 {

	static int num; // 수의 개수
	static int[] nums; // 수열
	static int[] operators = new int[4];

	static int maxVal = Integer.MIN_VALUE;
	static int minVal = Integer.MAX_VALUE;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		num = sc.nextInt();
		nums = new int[num];
		for (int i = 0; i < num; i++)
			nums[i] = sc.nextInt(); // 수열 초기값

		for (int i = 0; i < 4; i++)
			operators[i] = sc.nextInt(); // 사칙연산 개수

		backtracking(nums[0], 1);
		
		System.out.println(maxVal);
		System.out.println(minVal);

	}

	static void backtracking(int sum, int idx) {
		if (idx == num) {
			maxVal = Integer.max(sum, maxVal);
			minVal = Integer.min(sum, minVal);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] <= 0)
				continue;

			operators[i]--;
			if (i == 0)
				backtracking(sum + nums[idx], idx + 1);
			else if (i == 1)
				backtracking(sum - nums[idx], idx + 1);
			else if (i == 2)
				backtracking(sum * nums[idx], idx + 1);
			else if (i == 3)
				backtracking(sum / nums[idx], idx + 1);
			operators[i]++;
		}

	}

}
