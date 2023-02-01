import java.util.Scanner;

public class Th_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] rank = new int[N];
        int[] weight = new int[N];
        int[] height = new int[N];

        for(int i=0; i<N; i++) {
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                
                // j가 i보다 덩치 클 때
                if(weight[i] < weight[j] && height[i] < height[j])
                    rank[i]++;

                // i가 j보다 덩치 클 때
                if(weight[i] > weight[j] && height[i] > height[j])
                    rank[j]++;
            }
        }

        for(int r : rank) {
            System.out.print((r+1) + " ");
        }
    }
}
