import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		backTracking(0);
		System.out.println(sb.toString());

	}

	public static void backTracking(int k) {
		// 종료조건
		if (k == m) {
			for (int e : arr) {
				sb.append(e + " ");
			}
			sb.append("\n");
			return;
		}

		// 중복과 관계없이 재귀로 되돌아감
		for (int i = 0; i < n; i++) {
			arr[k] = i + 1;
			backTracking(k + 1);

		}

	}

}
