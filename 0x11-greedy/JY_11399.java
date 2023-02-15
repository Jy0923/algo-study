import java.util.Arrays;
import java.util.Scanner;

public class JY_11399 {

	int n;
	int[] arr;
	int answer = 0;
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i-1];
		}
		for (int i = 0; i < n; i++) {
			answer += arr[i];
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		new JY_11399().solution();
	}
}
