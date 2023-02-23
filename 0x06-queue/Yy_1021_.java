package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1021_회전하는큐 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 큐의 크기
		int m = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수
		LinkedList<Integer> q = new LinkedList<>();
		int cnt = 0;
		
		for(int i=1; i<=n; i++)
			q.offer(i);
		
		int[] result = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) 
			result[i] = Integer.parseInt(st.nextToken());
		
		
		for(int k=0; k<m; k++) {
			int idx = q.indexOf(result[k]);
			int halfIdx;
			
			if(q.size() % 2 == 0)
				halfIdx = q.size() / 2 -1;
			else
				halfIdx = q.size() / 2;
			
			
			if(idx <= halfIdx) {
				for(int j=0; j<idx; j++) {
					int tmp = q.pollFirst();
					q.offerLast(tmp);

					cnt++;
				}
			}
			else {
				for(int j=0; j<q.size() - idx; j++) {
					int tmp = q.pollLast();
					q.offerFirst(tmp);
					
					cnt++;
				}
			}
			
			q.pollFirst();
		}
		
		System.out.println(cnt);
	}
}
