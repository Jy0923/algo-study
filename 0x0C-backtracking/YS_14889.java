import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[][] arr;
	static boolean[] isUsed;
	static int min;

	// 1번팀만을 담는 리스트 team1을 추가한다.
	static ArrayList<Integer> team1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		min = Integer.MAX_VALUE;
		team1 = new ArrayList<>();
		isUsed = new boolean[size];

		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backTracking(0, 0);
		System.out.println(min);

	}

	public static void backTracking(int start, int k) {
		// 종료조건
		// team의 인덱스가 전체 사이즈의 절반이 되었을 때 종료한다.
		// team1과 team2의 스코어를 나눈다.
		// 만약 team1 리스트에 i+1과 j+1이 포함되어 있다면 team1의 스코어가 올라간다.
		// team1 리스트에 i+1이나 j+1이 포함되어있지 않다면 team2의 스코어가 올라간다.
		// 두 스코어를 비교해서 최솟값을 갱신한다.
		if (k == (size / 2)) {
			int teamOneScore = 0;
			int teamTwoScore = 0;
			int result = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (team1.contains(i + 1) && team1.contains(j + 1)) {
						teamOneScore += arr[i][j];
					} else if (!(team1.contains(i + 1) || team1.contains(j + 1))) {
						teamTwoScore += arr[i][j];
					}
				}
			}

			if (teamOneScore > teamTwoScore) {
				result = teamOneScore - teamTwoScore;
			} else if (teamOneScore < teamTwoScore) {
				result = teamTwoScore - teamOneScore;
			} else {
				result = 0;
			}
			if (result < min) {
				min = result;
			}
			return;

		}

		// 중복을 잡기 위해 isUsed 배열을 사용한다.
		// 가치지기를 위해서 i+1 부터 탐색을 시작한다.
		for (int i = start; i < size; i++) {
			if (!isUsed[i]) {
				team1.add(i + 1);
				isUsed[i] = true;
				backTracking(i + 1, k + 1);
				team1.remove(k);
				isUsed[i] = false;
			}
		}

	}

}
