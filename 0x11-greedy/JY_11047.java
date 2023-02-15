import java.util.Scanner;

public class JY_11047 {

	int n, k;
	int[] arr;
	int cnt;
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = n-1; i >= 0; i--) {
			cnt += (k/arr[i]);
			k %= arr[i];
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new JY_11047().solution();
	}
}
