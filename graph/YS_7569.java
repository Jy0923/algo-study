import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 3차원 배열을 -1로 초기화
 * 2. dx, dy, dz로 델타 배열 생성
 * 3. bfs 돌리면서 값을 저장
 * 4. 가장 큰 수를 출력
 * @author 영석
 *
 */

public class Main {
	static int m;
	static int n;
	static int h;
	static int[][][] map;
	static int[][][] isUsed;
	static int count;
	static Queue<Node> queue = new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	
	
    public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][n][m];
		isUsed = new int[h][n][m];
		// isUsed 배열 -1로 초기화
		for(int height = 0; height < h ; height++) {
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < m ; col++) {
					isUsed[height][row][col] = -2;
				}
			}
		}
		
		
		for(int height = 0; height < h ; height++) {
			for(int row = 0; row < n; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0; col < m ; col++) {
					map[height][row][col] = Integer.parseInt(st.nextToken());
					if(map[height][row][col] == 1) {
						isUsed[height][row][col] = 0;
						queue.offer(new Node(height, row, col));
					} else if (map[height][row][col] == -1) {
						isUsed[height][row][col] = -1;
					}
				}
			}
		}
		



		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			int height = temp.height;
			int row = temp.row;
			int col = temp.col;
			
			for(int i = 0; i < 6 ; i++) {
				int nx = height + dx[i];
				int ny = col + dy[i];
				int nz = row + dz[i];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= m || nz >= n) {
					continue;
				}
				if(map[nx][nz][ny] != 0 || isUsed[nx][nz][ny] != -2) continue;
				isUsed[nx][nz][ny] = isUsed[height][row][col] + 1;
				queue.offer(new Node(nx, nz, ny));
				
			}
			
			
		}
		
		int max = Integer.MIN_VALUE;
		loop:
		for(int height = 0; height < h ; height++) {
			for(int row = 0; row < n; row++) {
				for(int col = 0; col < m ; col++) {
					if(isUsed[height][row][col] == -2) {
						max = -1;
						break loop;
					}
					
					if(isUsed[height][row][col] > max) {
						max = isUsed[height][row][col];
					}
				}
			}
		}
		System.out.println(max);

		
		
		
	}
    
    static class Node{
    	int row;
    	int col;
    	int height;
    	public Node(int height, int row, int col) {
    		this.row = row;
    		this.col = col;
    		this.height = height;
    	}
    }
}
