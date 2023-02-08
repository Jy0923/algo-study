import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		isUsed = new boolean[n];
		backTracking(0);

	}

	public static void backTracking(int k) {
		// 종료조건
		if (k == m) {
			for (int e : arr) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isUsed[i]) {
				
				// 만약 k가 0이 아니면서 이전 값보다 작은 경우 continue
				if (k != 0 && i + 1 < arr[k - 1]) {
					continue;
				}
				arr[k] = i + 1;
				isUsed[i] = true;
				backTracking(k + 1);
				isUsed[i] = false;
			}
		}

	}

}
