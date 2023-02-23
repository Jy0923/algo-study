import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_회전하는큐_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //큐의 크기
        int M = sc.nextInt(); //뽑아내려고 하는 수의 개수
        int minCnt = 0; //최소 연산 수

        Queue<Integer> que = new LinkedList<>();

        //큐에 정보 입력
        for(int i=1; i<=N; i++) {
            que.offer(i);
        }

        for(int i=0; i<M; i++) {
            int find = sc.nextInt(); //찾으려는 수

            int tmpCnt = 0; //해당 수 찾는 연산1 수
            while(true) {
                int number = que.peek(); //큐에서 뽑을 수
                if(find == number) { //같은 경우
                    //현재 연산1의 횟수랑 큐의 크기 - 연산1 횟수(= 연산 2의 횟수) 비교
                    //더 작은 값 추가
                    minCnt += Math.min(tmpCnt, que.size()-tmpCnt);
                    que.poll(); //찾은 값 버리기
                    break;
                }
                que.offer(que.poll()); //연산1
                tmpCnt++;
            }
        }
        System.out.println(minCnt);
    }
}
