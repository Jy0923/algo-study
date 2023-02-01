import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int r = 3;
	// 배열의 크기를 n!/r!(n-r)! 로 저장
	static int length = (factorial(N)) /(factorial(r) * factorial(N-r));
	static int[] result = new int[length];

	
	public static void main(String[] args) {
		// max값 갱신 위해 max 값 저장
		int max = 0;
		
		// M값과 일치하면 true 
		boolean match = false;

		int M = sc.nextInt();

		// N개의 배열 생성
		int[] arr = new int[N];
		for(int i=0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 조합 계산을 위해 boolean 배열 생성
		boolean[] visited = new boolean[N];

		// 조합의 합을 구하는 combination 메소드 호출
		combination(arr, visited, 0, N, r);

		// result 배열에서 M과 일치하면 match = true, 일치하는 값이 없으면 최대값 갱신
		for (int e : result) {
			if (e == M) {
				match = true;
				break;
			}
			if (e < M && e > max) {
				max = e;
			}
		}

		// match 값에 따라 값 출력
		if (match) {
			System.out.println(M);
		} else {
			System.out.println(max);
		}
		
		
	}

	// 조합을 계산하는 메소드
	static void combination(int arr[], boolean visited[], int start, int n, int r) {
                            
		if (r == 0) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] == 0) {
					result[i] = print(arr, visited, n);
					break;
				}
			}
			return;

		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}

	}

	// 입력받은 배열의 합을 반환
	static int print(int arr[], boolean visited[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				sum += arr[i];
			}
		}
		return sum;
	}
	
	// 팩토리얼 계산을 위한 메소드
	public static int factorial(int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return factorial(n-1) * n;
		}
	}
}