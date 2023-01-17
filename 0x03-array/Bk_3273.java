package array;

import java.util.Scanner;

public class Bk_3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = sc.nextInt();
		
		int[] cnt = new int[sum + 1];
		
		for (int i = 0; i < n; i++) {
			if(arr[i] <= sum)
				cnt[arr[i]]++;
		}

		int result = 0;
		for (int i = 0; i < (sum+1)/2; i++) {
			if (cnt[i] == 1 && cnt[sum-i]==1)
				result++;
		}

		System.out.println(result);

	}

}
