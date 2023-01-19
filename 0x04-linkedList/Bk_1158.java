package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bk_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}

		int[] arr = new int[N];
		int idx = 0;
		int remove = 0;
		for (int i = 0; i < N; i++) {
			remove = (remove + K - 1) % list.size();
			arr[idx++] = list.get(remove);
			list.remove(remove);
		}

		String result = "<";
		for (int i = 0; i < N; i++) {
			result += arr[i];
			if (i != N - 1)
				result += ", ";
			else
				result += ">";
		}

		System.out.println(result);
	}

}
