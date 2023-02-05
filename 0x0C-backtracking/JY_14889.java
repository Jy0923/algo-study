import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class JY_14889{

	int n;
	int[][] ability;
	
	int[] start;
	int[] link;
	boolean[] isused;
	
	int minDiff = Integer.MAX_VALUE;
	int diff;
	
	public int getTeamAbility(int[] team) {
		int teamAbility = 0;
		for (int i : team) {
			for (int j : team) {
				teamAbility += ability[i][j];
			}
		}
		return teamAbility;
	}
	
	public void backtracking(int k) {
		if (k == n/2) {
			
			for (int i = 0, linkIdx = 0; i < n; i++) {
				if (!isused[i]) {
					link[linkIdx++] = i;
				}
			}
			
			diff = Math.abs(getTeamAbility(start) - getTeamAbility(link));
			if (diff < minDiff) {
				minDiff = diff;
			}
			return;
		}
		
		int st = 0;
		if (k != 0) {
			st = start[k-1];
		}
		for (int i = st; i < n; i++) {
			if (!isused[i]) {
				start[k] = i;
				isused[i] = true;
				backtracking(k+1);
				isused[i] = false;
			}
		}
	}
	
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new int[n/2];
		link = new int[n/2];
		isused = new boolean[n];
		
		backtracking(0);
		System.out.println(minDiff);
	}
	
	public static void main(String[] args) throws IOException{
		new JY_14889().solution();
	}

}
