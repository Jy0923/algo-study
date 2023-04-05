import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	static int n;
	static int nums[];
	static int prime[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 소수만들기
		nums = new int[4000000];

		for (int i = 2; i < nums.length; i++) {
			nums[i] = i;
		}

		for (int i = 2; i < 4000000; i++) {
			int j = 2;
			while (i * j < 4000000) {
				nums[i * j] = 0;
				j++;
			}
		}
		prime = new int[4000000];
		int idx = 0;
		for (int i = 1; i < 4000000; i++) {
			if (nums[i] != 0) {
				prime[idx++] = nums[i];
			}
		}

		int count = 0;
		int st = 0;
		int ed = 0;
		int result = prime[ed];
		while (st < idx && ed < idx) {
			if (result == n) {
				count++;
				result += prime[++ed];
			}
			if (result < n) {
				ed++;
				result += prime[ed];
			} else if (result > n) {
				result -= prime[st];
				st++;
			}
		}

		System.out.println(count);

	}
}
