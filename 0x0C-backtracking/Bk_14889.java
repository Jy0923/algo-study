package backtracking;

import java.util.*;

public class Bk_14889 {

	static int n; // 총 인원 수
	static int[][] nums; // 상대 점수
	static boolean[] isused; // 인원 채택

	static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n][n];
		isused = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[i][j] = sc.nextInt();
			}
		}

		backtracking(0, 0);

		System.out.println(minVal);

	}

	static void backtracking(int cnt, int idx) {
		if (cnt == n / 2) { // 전체 인원을 뽑음
			int startVal = 0, linkVal = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
					if (isused[i] == true && isused[j] == true) {
						startVal += nums[i][j] + nums[j][i];
					}
					// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
					else if (isused[i] == false && isused[j] == false) {
						linkVal += nums[i][j] + nums[j][i];
					}
				}
			}

			minVal = Math.min(minVal, Math.abs(startVal - linkVal));

			return;
		}

		for (int i = idx; i < n; i++) {

			if (isused[i])
				continue;

			isused[i] = true;
			backtracking(cnt + 1, i);
			isused[i] = false;
		}

	}

}
