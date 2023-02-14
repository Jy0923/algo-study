import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_11660 {
	
	static int[][] prefixSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] read = br.readLine().split(" ");
		
		int N = Integer.parseInt(read[0]); //표의 크기
		int M = Integer.parseInt(read[1]); //합을 구해야 하는 횟수

		int[][] arr = new int[N+1][N+1]; //표
		prefixSum = new int[N+1][N+1]; //가로구간 누적합 배열
		
		for(int i=1; i<=N; i++) {
			read = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(read[j-1]);
				prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j];
			}
		}
		
		for(int i=0; i<M; i++) {
			read = br.readLine().split(" ");
			int x = Integer.parseInt(read[0]);
			int y = Integer.parseInt(read[1]);
			int nx = Integer.parseInt(read[2]);
			int ny = Integer.parseInt(read[3]);
		
			sb.append(getSum(x,y,nx,ny) + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static int getSum(int x, int y, int nx, int ny) {
		int sum = 0;	
		
		for(int i=x; i<=nx; i++) {
			sum += prefixSum[i][ny] - prefixSum[i][y-1];
		}
		
		return sum;
	}
}