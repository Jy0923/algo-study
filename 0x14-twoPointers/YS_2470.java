import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		StringTokenizer str = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;

		int ed = n - 1;
		int st = 0;
		int minSt = -1;
		int minEd = -1;

		while (st < ed) {
			int diff = arr[st] + arr[ed];

			if (Math.abs(diff) < min) {
				min = Math.abs(diff);
				minSt = st;
				minEd = ed;
			}

			if (diff > 0)
				ed--;
			else
				st++;
		}

		System.out.println(arr[minSt] + " " + arr[minEd]);

	}

}
