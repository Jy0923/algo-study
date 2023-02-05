import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int size;
	static int result;
	
	// 아래 방향을 확인할 isUsed1 배열
	static boolean[] isUsed1;
	
	// 왼쪽 대각선 방향을 확인할 isUsed2 배열
	static boolean[] isUsed2;
	
	// 오른쪽 대각선 방향을 확인할 isUsed3 배열
	static boolean[] isUsed3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());

		result = 0;
		isUsed1 = new boolean[40];
		isUsed2 = new boolean[40];
		isUsed3 = new boolean[40];
		backTracking(0);
		System.out.println(result);
	}

	public static void backTracking(int k) {
		// 깊이가 size에 도달했을 때 결과값에 1을 더하고 리턴
		if (k == size) {
			result += 1;
			return;
		}

		for (int i = 0; i < size; i++) {

			// 아래, 왼쪽 대각선, 오른쪽 대각선이 모두 false라면 진행
			if (isUsed1[i] || isUsed2[i + k] || isUsed3[k - i + size - 1]) {
				continue;
			}
			
			// 세 배열을 모두 true로 바꿔주고 재귀 호출
			isUsed1[i] = true;
			isUsed2[i + k] = true;
			isUsed3[k - i + size - 1] = true;
			backTracking(k + 1);
			
			// 다시 세 배열을 false로 하고 다음 인덱스로
			isUsed1[i] = false;
			isUsed2[i + k] = false;
			isUsed3[k - i + size - 1] = false;
		}

	}
}
