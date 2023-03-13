package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6549_히스토그램에서가장큰직사각형 {
	
	static StringTokenizer st;
	static int n;
	static long[] arr;
	static long maxArea;
	
	static long recur(int start, int end) {
		
		if(end - start == 0) 
			return arr[start];
		
		int mid = (start + end) / 2;
		
		long leftArea = recur(start, mid);
		long rightArea = recur(mid+1, end);
		
		maxArea = Math.max(leftArea, rightArea);
		
		int midStart = mid;
		int midEnd = mid + 1;
		long midHeight = Math.min(arr[midStart], arr[midEnd]);
		
		maxArea = Math.max(maxArea, midHeight * 2);
		
		while(midStart > start || midEnd < end) {
			if(midEnd < end && (midStart == start || arr[midStart - 1] < arr[midEnd + 1])) {
				
				midEnd++;
				midHeight = Math.min(midHeight, arr[midEnd]);
			}
			else {
				midStart--;
				midHeight = Math.min(midHeight, arr[midStart]);
			}
			
			maxArea = Math.max(maxArea, midHeight * (midEnd - midStart + 1));
		}
		
		return maxArea;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			arr = new long[n];
			for(int i=0; i<n; i++)
				arr[i] = Long.parseLong(st.nextToken());
			
			maxArea = 0;
			
			System.out.println(recur(0, n-1));
		}
	}
}



/*
 
height -1 할떄 필요없는거 줄여보기

public class No6549_히스토그램에서가장큰직사각형2 {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static long[] arr, tmp;
	static long maxArea, area;
	static long maxHeight = 0;
	static boolean allPlus;
	
	// 매개변수로 높이를 적어서 해보쟈
	static void recur(long height) {
		
		// 종료 조건
		if(height == 0)	
			return;
		
		area = 0;
		
		tmp = new long[n];
		for(int i=0; i<n; i++) 
			tmp[i] = arr[i] - height;
		
		allPlus = true;
		for(int i=0; i<n; i++) {
			// 0보다 클리는 없고 0이겠지(maxHeight니까)
			if(tmp[i] >= 0) 
				area += height;
			else {
				if(maxArea < area)
					maxArea = area;
				
				area = 0;
				allPlus = false;
			}
		}
		
		if(maxArea < area)
			maxArea = area;
		
		// 빠른 종료조건
		if(allPlus) 
			return;
		
		recur(height - 1);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			arr = new long[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				if(maxHeight < arr[i])
					maxHeight = arr[i];
			}
			
			maxArea = 0;
			
			recur(maxHeight);
			
			sb.append(maxArea).append("\n");
		}
		
		System.out.println(sb);
	}
}
  
  
  
  
*/