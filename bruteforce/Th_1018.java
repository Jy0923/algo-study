import java.util.Scanner;

public class Th_1018 {
	
	static int min = Integer.MAX_VALUE;
	static boolean[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		board = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			
			for(int j=0; j<M; j++) {
				//백이면 true, 흑이면 black
				if(str.charAt(j) == 'W')
					board[i][j] = true;
			}
		}
		
		//8x8이 나오는 자리는 모두 탐색
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				check(i, j);
			}
		}
		
		
		System.out.println(min);
	}
	

	public static void check(int x, int y) {
		
		//이전 색
		boolean before = board[x][y];
		
		//시작지점 흑, 백 각각 두번
		for(int k=0; k<2; k++) {
			int cnt = 0;
	
			for(int i=x; i<x+8; i++) {
				//행이 바뀌면 색 바꿔주기
				before = !before;
				
				for(int j=y; j<y+8; j++) {
					//현재색
					boolean now = board[i][j];
				
					if(now == before) {
						//같으면 현재색 바꿔주고 이전색에 넣고
						//cnt++
						before = !board[i][j];
						cnt++;
					} else {
						//다르면 그대로
						before = board[i][j];
					}
				}
			}
			//최소값인지 확인
			min = Math.min(min, cnt);
	
			//백으로 시작했으면 흑으로, 흑으로 시작했으면 백으로
			before = !board[x][y];
		}
	}
}