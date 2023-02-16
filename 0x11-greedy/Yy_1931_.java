package greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
// https://st-lab.tistory.com/145 구글링
public class No1931_회의실배정 {
	
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// times[][0] 은 시작시간
		// times[][1] 은 종료시간
		
		int[][] times = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		// ★★★★★ 어려웡
		// 종료시간으로 정렬을 해야함
		// -> 종료시간이 빠를수록 많은 회의를 할 수 있기 때문에!
		Arrays.sort(times, new Comparator<int[]>() {
			
			// 재정의하기 Comparator 겅부!!!
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간 같을경우 -> 시작시간이 빠른 순으로 정렬
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
			
		});
		
		
		int cnt = 0;
		int endTime = 0; // 이전 종료시간
		
		for(int i=0; i<n; i++) {
			
			// 이전 종료시간이 다음 회의 시작시간보다 같거나 작다면 갱신
			if(endTime <= times[i][0]) {
				endTime = times[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
