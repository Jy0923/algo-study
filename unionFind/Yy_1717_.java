package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1717 {
	
	static int n, m; // n: n+1개의 집합,  m: 연산의 개수
	static int[] arr;
	
	// 부모 노드를 찾는 메서드
	static int getParent(int a) {
		// 배열 인덱스와 값이 같다면 해당 값 리턴(루트 노드를 찾기)
		if(arr[a] == a)
			return a;
		
		// 배열의 값을 인덱스로 갖는 값 리턴
//		return getParent(arr[a]);
		return arr[a] = getParent(arr[a]);
	}
	
	// 두 부모노드를 합치는 함수
	static void union(int a, int b) {
		a = getParent(a); 
		b = getParent(b); // 루트 노드를 찾음
		
		if(a == b) return; // 루트가 같다면 이미 연결되어있는 것
		
		// 일반적으로 더 작은쪽으로 합침 
		if(a < b) 
			arr[b] = a;
		else 
			arr[a] = b;
	}
	
	// 두 노드가 연결되어있는지 판별(같은 부모를 가지는지 확인)
	static boolean isUnion(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a == b) return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		// 본인의 노드를 본인으로 저장(초기화)
		for(int i=0; i<=n; i++) 
			arr[i] = i;
		
		for(int tc=0; tc<m; tc++) {
			st = new StringTokenizer(br.readLine());
			int calc = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(calc == 0) 
				union(a, b);
			else 
				System.out.println(isUnion(a, b) ? "YES" : "NO");
		}
		
		System.out.println(Arrays.toString(arr));
	}
}	
