import java.util.Arrays;
import java.util.Scanner;

public class main {
	static char[][] arr;

	public static void star(int num, int row, int col) {
		int mid = ((num/3) + 1)/2;
		
		if (num == 1) {
			return;
		}
		
		for (int r = row - num; r < row; r++) {
			for (int c = col - num; c < col; c++) {
				if ((num / 3 <= r && r < (2 * num) / 3) && (num / 3 <= c && c < (2 * num) / 3)) {
					arr[r][c] = ' ';
				} else {
					arr[r][c] = '*';
					if (num == 3) {
						star(num/3, r, r);
					} else if ((r == num/3 - mid || r == (2 * num)/3 - mid || r == num - mid) && (c == num/3 - mid || c == (2 * num)/3 - mid || c == num - mid)){
						star(num / 3, r + mid, c + mid);
					}

				}
			}

		}}

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int row = num;
		int col = num;

		arr = new char[num][num];
		star(num, row, col);
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
	}

}
// 5시간동안 시도해봤으나 9이상으로 구현이 안되서 포기,,,
// 아래 풀이가 가장 깔끔한 풀이인거같은데 이해 불가... 집단지성을 모아봐요

//private static String[][] array;
//
//public static void star(int x, int y, int n) {
//    if(n == 1) {
//        array[x][y] = "*";
//        return;
//    }
//
//    int m = n / 3;
//
//    for(int i = 0; i < 3; i++) {
//        for(int j = 0; j < 3; j++) {
//            if(i == 1 && j == 1) {
//                continue;
//            }
//            star(m * i + x, m * j + y, m);
//        }
//    }