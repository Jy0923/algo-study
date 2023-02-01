package _230130;

import java.util.Scanner;

// 덩치
public class Yy_7568 {
	
	// (x, y) = (몸무게, 키)
	// 키와 몸무게 둘 다 커야 덩치가 크다.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) 
				arr[i][j] = sc.nextInt();
		}
		
		// 0, 1, 2, ... n-1 까지 나보다 큰 애들 있으면 +1 하기 (등수니까 반대로)
		int[] rank = new int[n]; 
		
		
		for(int i=0; i<n; i++) {
			// 등수는 1등부터 시작이니까 기본베이스 +1
			rank[i]++;
			
			for(int j=0; j<n; j++) {
				// 본인빼고 다 비교하기
				if(i != j) {
					if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) 
						rank[i]++;
				}
			}
		}
		
		for(int i=0; i<n; i++) 
			System.out.print(rank[i] + " ");
	}

}
