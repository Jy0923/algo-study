import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Th_17124 {

    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            String[] tmp = br.readLine().split(" ");

            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);

            //배열 A,B 초기화
            long[] A = new long[n];
            long[] B = new long[m];

            //배열 A 할당
            String[] aArr = br.readLine().split(" ");
            for(int i=0; i<n; i++) {
                A[i] = Long.parseLong(aArr[i]);
            }

            //배열 B 할당
            String[] bArr = br.readLine().split(" ");
            for(int i=0; i<m; i++) {
                B[i] = Long.parseLong(bArr[i]);
            }

            //배열 B 정렬(오름차순)
            Arrays.sort(B);

            sum = 0;

            //배열 C의 값 구하기 (배열 C를 만들지 않고 바로 sum에 더함)
            for(int i=0; i<n; i++) {
                long now = A[i]; // 배열 A[i]의 값

                divide(B, 0, B.length-1, now);
            }
            
            System.out.println(sum);
        }
    }

    private static void divide(long[] B, int left, int right, long now) {
        //나누어지다 값이 2개만 남으면 비교 시작
        if((right - left) <= 1) {
            if(Math.abs(now - B[left]) <= Math.abs(now - B[right]))
                sum += B[left];
            else
                sum += B[right];
            return;
        }

        //중간 인덱스
        int mid = (left + right)/2;

        //B배열 mid 값과 같으면 sum에 값 추가
        if(B[mid] == now) {
            sum += now;
            return;
        
        //A[i]값이 더 크면 뒤쪽(값이 더 큰쪽) 배열 나누기
        } else if(B[mid] > now) {
            divide(B, left, mid, now);

        //A[i]값이 더 작으면 앞쪽(값이 더 작은쪽) 배열 나누기
        } else if(B[mid] < now) {
            divide(B, mid, right, now);
        }
    }
}