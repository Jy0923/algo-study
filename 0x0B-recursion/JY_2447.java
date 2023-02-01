import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JY_2447 {
	
	int N;
	char[][] arr;
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public void makeStar(int n, int startRow, int startCol) {
		if (n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if ((i == 1) && (j == 1)) {
						arr[startRow + i][startCol + j] = ' ';
					}else {
						arr[startRow + i][startCol + j] = '*';
					}
					
				}
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((i == 1) && (j == 1)) {
					continue;
				}else {
					makeStar(n/3, startRow + (n/3) * i, startCol + (n/3) * j);
				}
			}
		}
	}
	
	public void solution() throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		makeStar(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '*') {
					bw.write('*');
				}else {
					bw.write(' ');
				}
			}
			bw.newLine();
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		new JY_2447().solution();
	}
}
