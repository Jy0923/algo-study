import java.io.IOException;
import java.util.Scanner;

public class Th_2447 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        arr = new String[N][N];

        //재귀 시작
        star(0, 0, N);
        
        //출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                //공백부분이면 공백 넣어주기
                if(arr[i][j] == null)
                    sb.append(" ");
                else
                    sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void star(int x, int y, int N) {
        //별 입력
        if(N == 1) {
            arr[x][y] = "*";
            return;
        }

        int size = N/3;
        for (int i=x; i<x+N; i+=size) {
            for (int j=y; j<y+N; j+=size) {
                //공백이 아니면 재귀함수
                if ((i/size)%3!=1 || (j/size%3!=1))
                    star(i, j, size);
            }
        }
    }
}
