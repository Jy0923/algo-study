import java.util.Scanner;

public class JY_1051 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}

		int maxSide = Math.min(n, m);
		int maxSize = 0;
		int leftTop, rightTop, leftBottom, rightBottom;
		boolean check;

		for (int side = 1; side <= maxSide; side++) {
			check = false;
			for (int i = 0; i < n - side + 1; i++) {
				for (int j = 0; j < m - side + 1; j++) {
					leftTop = map[i][j];
					rightTop = map[i][j + side - 1];
					leftBottom = map[i + side - 1][j];
					rightBottom = map[i + side - 1][j + side - 1];
					if (leftTop == rightTop && leftTop == leftBottom && leftTop == rightBottom) {
						maxSize = side * side;
						check = true;
						break;
					}
				}
				if (check) {
					break;
				}
			}
		}
		System.out.println(maxSize);
	}

}
