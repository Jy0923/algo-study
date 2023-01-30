import java.util.Arrays;
import java.util.Scanner;

public class Th_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드의 개수
        int M = sc.nextInt(); // 블랙잭
        int[] cards = new int[N]; //카드들

        for(int i=0; i<N; i++) {
            cards[i] = sc.nextInt();
        }

        //오름차순으로 정렬
        Arrays.sort(cards);

        System.out.println(playBlackjack(N, M, cards));
    }

    private static int playBlackjack(int N, int M, int[] cards) {
        int blackjack = 0; // 블랙잭과 가장 가까운 수

        for(int i = 0; i< N -2; i++) {
            for(int j = i+1; j< N -1; j++) {
                for (int k = j + 1; k < N; k++) {
                    //세개의 카드 수의 합
                    int tmp = cards[i] + cards[j] + cards[k];
                    
                    //M보다 크면 넘기기
                    if (tmp > M) continue;

                    //M이 나오면 리턴
                    if (tmp == M) return M;

                    //M보다 작으면서 가장 큰 값
                    blackjack = Math.max(blackjack, tmp);
                }
            }
        }

        return blackjack;
    }
}
