package silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14888 {
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] operator = new int[4];
	static int[] arr;
	static int n;
	
										 // depth
	public static void recursion(int num, int i) {
		
		// 종료 조건
		if(i == n) { 
			max = Math.max(max, num);
			min = Math.min(min, num);
			
			return;
		}
		
		// operator 배열 탐색
		for(int idx=0; idx<4; idx++) {
			
			// 해당 연산자가 1개 이상 있는 경우에 연산자를 -1해주고 사용
			if(operator[idx] > 0) {
				operator[idx]--;
				
				switch(idx) {
				case 0: 
					// depth를 1 증가시키고 num 계산 후 재귀
					recursion(num + arr[i], i + 1);
					break;
				case 1:
					recursion(num - arr[i], i + 1);
					break;
				case 2:
					recursion(num * arr[i], i + 1);
					break;
				case 3:
					recursion(num / arr[i], i + 1);
					break;
				}
				
				// 다음 재귀를 위해 초기화
				operator[idx]++;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		// 숫자 순열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 집합
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) 
			operator[i] = Integer.parseInt(st.nextToken());
		
		
		recursion(arr[0], 1);
		
		System.out.println(max);
		System.out.println(min); 
		
	}

}
