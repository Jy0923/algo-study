import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1 ;i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
