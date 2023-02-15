import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[10001]; // 포도주 양
        int[] max = new int[10001]; // 각 위치마다 최대 포도주 양

        for(int i=1; i<=N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        max[1] = wine[1];
        max[2] = wine[1] + wine[2];
        max[3] = Math.max(max[2],Math.max(wine[1] + wine[3], wine[2] + wine[3]));

        for(int i=4; i<=N; i++) {
            //현재 포도주 안마시는 경우
            //이전 포도주 안마시는 경우
            //이전이전 포도주 안마시는 경우
            //모두 고려
            max[i] = Math.max(Math.max(max[i-1],wine[i]+max[i-2]),wine[i]+wine[i-1]+max[i-3]);
        }

        //마지막 or 마지막 이전이 최댓값
        int result = Math.max(max[N], max[N-1]);

        System.out.print(result);
    }
}