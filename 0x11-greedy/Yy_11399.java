package greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// pArr에서 큰 수가 앞에 줄 설수록 누적합의 합계가 당연히 커짐
		// 따라서 오름차순 정렬후 누적합의 합을 구해야 최솟값이 될듯
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pArr = new int[n];
		for(int i=0; i<n; i++) 
			pArr[i] = Integer.parseInt(st.nextToken());
		
		// 선택 정렬
		for(int i=0; i<n-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<n; j++) {
				if(pArr[minIdx] > pArr[j])
					minIdx = j;
			}
			
			int tmp = pArr[i];
			pArr[i] = pArr[minIdx];
			pArr[minIdx] = tmp;
		}
		
		
		// 누적합 배열
		int[] prefixSum = new int[n];
		prefixSum[0] = pArr[0];
		
		// 결과 저장할 변수
		int sum = prefixSum[0];
		
		for(int i=1; i<n; i++) {
			prefixSum[i] = prefixSum[i-1] + pArr[i];
			sum += prefixSum[i];
		}
		
		System.out.println(sum);
		
	}
}
