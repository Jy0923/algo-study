import java.util.Scanner;

//백준 골드4 N-Queen
public class Th_9663 {

    static int N; // N체스판 길이
    static int answer = 0; //가능한 방법 수
    static int[] qx; //퀸 놓은 x 좌표
    static int[] qy; //퀸 놓은 y좌표

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        qx = new int[N];
        qy = new int[N];

        doChess(0,0);

        System.out.println(answer);
    }

    private static void doChess(int cnt,int row) {
        //모두 놓는데 성공한 경우
        if(cnt == N) {
            answer++;
            return;
        }

        for(int i=0; i<N; i++) {
            
            boolean flag = true; //겹치는 자리 없는지 확인
            
            // 이전에 놓은 퀸 순회
            for(int j=0; j<cnt; j++) {
                //세로
                if(qy[j] == i) {
                    flag = false;
                    break;
                }
            
                //오른쪽 대각선
                if((qx[j]+qy[j]) == row+i){
                    flag = false;
                    break;
                }

                //왼쪽 대각선
                if((qx[j]-qy[j]) == row-i) {
                    flag = false;
                    break;
                }
            }

            //겹치면 continue
            if(!flag) continue;

            //퀸 놓은 위치 저장
            qx[cnt] = row;
            qy[cnt] = i;
            
            //계속
            doChess(cnt+1, row+1);
        }
    }
}