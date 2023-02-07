package dp;

import java.util.Scanner;

public class Bk_2579_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[301];

		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
		}

		int[] maxScore = new int[301];

		maxScore[1] = arr[1];
		maxScore[2] = arr[1] + arr[2];
		maxScore[3] = Math.max(arr[1], arr[2]) + arr[3];

		for (int i = 4; i <= num; i++)
			maxScore[i] = Math.max(maxScore[i - 2], maxScore[i - 3] + arr[i - 1]) + arr[i];

		System.out.println(maxScore[num]);

	}

}
