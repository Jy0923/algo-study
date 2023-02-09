import java.util.Scanner;

public class Th_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] price = new int[N][3]; // N번집을 각각의 색으로 칠하는 비용을 담는 배열
        int[][] least = new int[N][3]; // 각 경우마다 최소 비용을 담는 배열
        int min = Integer.MAX_VALUE; // 최소 비용

        // price 배열 값 할당
        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                price[i][j] = sc.nextInt();
            }
        }

        // least 배열 값 할당
        for(int i=0; i<N; i++) {
            for(int j=0; j<3; j++) {
                if(i == 0) {
                    //첫번째 집의 경우 본인 가격만
                    least[i][j] = price[i][j];
                    continue;
                }
                // 최솟값을 구해야하니까 일단 Integer.MAX_VALUE로
                least[i][j] = Integer.MAX_VALUE;
            }
        }

        //두번째 집 칠할때부터 마지막 집까지 반복
        for(int i=1; i<N; i++) {
            //3가지 색 반복
            for(int j=0; j<3; j++) {
                //바로 이전 집까지의 색마다 최소비용
                for(int k=0; k<3; k++) {
                    //바로 이전 집이랑 색이 같으면 패스
                    if(j == k) continue;
                    //경우마다 최소비용 비교
                    least[i][j] = Math.min(least[i][j], least[i-1][k] + price[i][j]);
                }
            }
        }

        //마지막집까지 다 칠한 경우의 수 돌면서 최소비용 찾기
        for(int i=0; i<3; i++) {
            min = Math.min(min, least[N-1][i]);
        }

        System.out.println(min);
    }
}