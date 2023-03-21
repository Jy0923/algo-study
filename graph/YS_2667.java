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
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] isUsed;
	static Queue<Node> queue = new LinkedList<>();
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		isUsed = new boolean[n][n];
		for (int row = 0; row < n; row++) {
			String line = br.readLine();
			for(int col = 0; col < n;col++) {
				map[row][col] = line.charAt(col) - '0';
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				if(map[row][col] == 1 && isUsed[row][col] == false) {
					int result = bfs(row, col);
					list.add(result);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}
    
    static int bfs(int r, int c) {
    	queue.offer(new Node(r,c));
    	isUsed[r][c] = true;
    	int cnt = 0;
    	
    	while(!queue.isEmpty()) {
    		Node target = queue.poll();
    		cnt++;
    		int row = target.row;
    		int col = target.col;
    		
    		for(int i = 0 ; i < 4 ;i++	) {
    			int nr = row + dr[i];
    			int nc = col + dc[i];
    			if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
    			if(map[nr][nc] != 1 || isUsed[nr][nc]) continue;
    				isUsed[nr][nc] = true;
    				queue.offer(new Node(nr,nc));
    			}
    		}
    	
    	return cnt;
    }
    
    static class Node{
    	int row;
    	int col;
    	public Node(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }
}
