import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		System.out.println(find(a, b, c));

	}

	public static long find(long x, long y, long z) {
		if (y == 1) {
			return x % z;

		}

		long next = y >> 1;

		if (y % 2 == 0) {
			long val = find(x, next, z) % z;
			return (val * val) % z;
		} else {
			long val = find(x, next, z) % z;
			return (val * val % z) * x % z;
		}
	}
}
