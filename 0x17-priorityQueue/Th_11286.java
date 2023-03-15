import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());

            if(cur == 0) {
                if(que.isEmpty()) answer.append(0 + "\n");
                else answer.append(que.poll() + "\n");
            } else {
                que.offer(cur);
            }
        }
        System.out.println(answer);

    }
}
