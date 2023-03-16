import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int start;
	static int[][] arr;
	static int[] visited;
	static int count = 1;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		arr = new int[2][m];
		visited = new int[n+1];
		for(int i = 0; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);

		}
		
		for(int i = 0; i< list.size(); i++) {
			Collections.sort(list.get(i));
		}
		

		dfs(start);
		for(int i = 1; i <= n ; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.println(sb);
		
	}
    
    static void dfs(int start) {
    	visited[start] = count++;

    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < list.get(start).size(); i++) {
    		int y = list.get(start).get(i);
    		if(visited[y] == 0) {
    			dfs(y);
    		}
    	}

    	
    	
    	
    	
    	
    	
    }
    

}

