import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	
	static int[] countArr = new int[3];
	static int[][] paper;
	static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = Integer.parseInt(sc.nextLine());
		paper = new int[size][size];
		
		//종이 정보 입력 받기
		StringTokenizer st;
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<size; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0,0,size); //같은 수로 되어 있는 지확인
		
		//출력
		for(int i=0; i<3; i++) {
			System.out.println(countArr[i]);
		}
	}
	
	/**
	 * 종이의 해당 범위가 모두 같은 수로 되어있는지 확인
	 */
	private static void search(int x, int y, int size) {
		int number = paper[x][y]; //현재 범위의 첫번째 숫자
				
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(paper[i][j] != number) {
					divide(x, y, size/3); //같지 않은 수가 있다면 분할
					return;
				}
			}
		}
		countArr[number+1]++; //종이의 수 추가
	}
	
	/**
	 * 해당 범위를 9개로 분할
	 */
	private static void divide(int x, int y, int size) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				search(x+(i*(size)), y+(j*(size)), size);
			}
		}
	}
}