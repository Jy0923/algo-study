import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bk_17124 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] A = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			int[] B = new int[m];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(B);

			int sum = 0;
			outer: for (int i = 0; i < n; i++) {

				int start = 0;
				int end = B.length - 1;
				int mid=0;

				while (end - start > 0) {
					mid = (start + end) / 2;

					if (A[i] == B[mid]) {
						sum += B[mid];
						break outer;
					}

					if (Math.abs(A[i]-B[mid]) > Math.abs(A[i]-B[mid+1])) {
						start = mid + 1;
					} else {
						end = mid-1;
					}

				}

				
				if (Math.abs(A[i] - B[start]) <= Math.abs(A[i] - B[mid]))
					sum += B[start];
				else
					sum += B[mid];

			}

			System.out.println(sum);

		}
	}
}
