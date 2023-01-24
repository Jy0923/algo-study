import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Th_3190 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static final int U=0, D=1, L=2, R=3;

    static int curD = R; //현재 방향

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        //아무것도 없으면 0, 뱀이 있으면 1, 사과는 2
        int[][] board = new int[N][N];

        //board에 사과 추가
        for(int i=0; i<K; i++)
            board[sc.nextInt()-1][sc.nextInt()-1] = 2;

        int L = sc.nextInt(); //방향 전환 횟수
        HashMap<Integer, Character> chgDir = new HashMap<>(); //방향 전환 정보

        //방향 전환 정보 추가
        for(int i=0; i<L; i++)
            chgDir.put(sc.nextInt(), sc.next().charAt(0));

        LinkedList<Coor> list = new LinkedList<>();
        list.add(new Coor(0, 0));
        board[0][0] = 1;
        
        int cnt=0; //현재 시간(초)
        
        while(true) {
            cnt++;

            Coor cur = list.getFirst(); //현재 뱀의 머리 위치

            int nx = cur.x + dx[curD];
            int ny = cur.y + dy[curD];

            //뱀의 몸, 벽에 부딪히면 끝
            if(nx<0 || nx>=N || ny<0 || ny>=N || board[nx][ny]==1) break;

            //사과가 없을 때
            if(board[nx][ny] == 0) {
                Coor last = list.removeLast();
                board[last.x][last.y] = 0;
            }

            //새로운 머리 위치 추가
            board[nx][ny] = 1;
            list.addFirst(new Coor(nx, ny));

            //방향 전환 시간인지 확인
            if (chgDir.containsKey(cnt))
                //방향 전환
                changeDirection(chgDir.get(cnt));
        }

        System.out.println(cnt);
    }

    private static void changeDirection(char chgDir) {
        if(curD == R) {
            if(chgDir == 'L') curD = U;
            else if(chgDir == 'D') curD = D;

        } else if(curD == D) {
            if(chgDir == 'L') curD = R;
            else if(chgDir == 'D') curD = L;

        } else if(curD == U) {
            if(chgDir == 'L') curD = L;
            else if(chgDir == 'D') curD = R;

        } else if(curD == L) {
            if(chgDir == 'L') curD = D;
            else if(chgDir == 'D') curD = U;
        }
    }

    static class Coor{
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}