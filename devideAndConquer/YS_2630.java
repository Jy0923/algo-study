import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int blueCnt = 0;
	static int whiteCnt = 0;
	static int[][] map;
	static int n;
	static boolean complete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		find(0,0,n);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);



	}
	
	
	public static void find(int x, int y, int size) {
		if(check(x,y, size)) {
			if(map[x][y] == 1) {
				blueCnt++;
			} else {
				whiteCnt++;
			}
			return;
		}
		
		int next = size>>1;
		
		find(x, y, next);
		find(x + next, y, next);
		find(x, y + next, next);
		find(x+next, y+next, next);
		
		
		
		
	}
	
	public static boolean check(int x, int y, int size) {
		complete = true;
		for (int i = x; i < x + size; i++) {
			for (int j = y ; j < y+size ; j++) {
				if (map[i][j] != map[x][y]) {
					complete = false;
					break;
				}
			}
		}
		return complete;
	}

}
