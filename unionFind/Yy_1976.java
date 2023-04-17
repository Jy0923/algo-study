package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 여행가자
// 유니온파인드로 전체가 같은 루트 노드를 갖는지 보면될듯!
public class BOJ_1976 {
	
	static int n; // 도시개수
	static int[] parent; // 루트 노드
	
	// a번 노드의 루트 노드를 반환하는 메서드(재귀)
	static int getParent(int a)	{
		
		// 종료조건
		if(a == parent[a])
			return a;
		
		return parent[a] = getParent(parent[a]);
	}
	
	// 두 집합을 합집합으로 만드는 메서드
	static void union(int a, int b) {
		
		a = parent[a];
		b = parent[b];
		
		if(a == b) return;
		
		if(a < b) 
			parent[b] = a;
		else 
			parent[a] = b;
	}
	
	// 두 집합이 합집합인지 확인하는 메서드
	static boolean isUnion(int a, int b) {
		
		a = parent[a];
		b = parent[b];
		
		if(a == b) return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i; // 본인으로 초기화
		}
		
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0) continue;
				
				union(i+1, j+1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int parent = getParent(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			int child = Integer.parseInt(st.nextToken());
			
			if(parent != getParent(child)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
}
