import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int start;
	static int[] visited;
	static int[] arr;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt = 1;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		// 배열리스트는 각 노드 안에 배열리스트가 있는 구
		// 지금 배열리스트는 비어있으니까 일단 칸들을 만들어주자 
		for(int i = 0;i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		visited = new int[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// u 노드에 v 추가 
			list.get(u).add(v);
			
			// v 노드에 u 추가 
			list.get(v).add(u);
			
		}
		
		for (int i = 1; i<=n; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		bfs(start);
		
		for(int i = 1; i <= n ;i++) {
			System.out.println(visited[i]);
		}
		
	}
    
    static void bfs(int start) {
    	if(visited[start] == 0) {
    		visited[start] = cnt++;
    		queue.add(start);
    	}
    	while(!queue.isEmpty()) {
    		int next = queue.poll();
    		for(int i = 0; i < list.get(next).size();i++) {
    			if(visited[list.get(next).get(i)] == 0) {
    				visited[list.get(next).get(i)] = cnt++;
    				queue.add(list.get(next).get(i));
    			}
    		}
    	}
    }
    
}
