import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Th_24060 {
    static int cnt = 0;
    static int answer = -1;
    static int K, N;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        int[] arr = new int[N];
        tmp = new int[N];

        str = br.readLine().split(" ");

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(str[i]);

        merge_sort(0, arr.length-1, arr);

        System.out.println(answer);
    }

    static void merge_sort(int s, int e, int[] arr) {
        if(s >= e) return;

        int m = (s + e) /2;

        merge_sort(s,m,arr);
        merge_sort(m+1,e,arr);
        merge(s,m,e,arr);
    }

    static void merge(int s, int m, int e, int[] arr) {
        int l = s;
        int r = m+1;
        int idx = s;

        while( l<=m && r<=e ) {
            if(arr[l] <= arr[r])
                tmp[idx++] = arr[l++];
            else
                tmp[idx++] = arr[r++];
        }

        while(l<=m)
            tmp[idx++] = arr[l++];

        while(r<=e)
            tmp[idx++] = arr[r++];


        for(int i=s; i<=e; i++) {
            arr[i] = tmp[i];
            cnt++;
            if(cnt == K)
                answer = tmp[i];
        }
    }
}