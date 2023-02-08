import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Th_1759 {

    static int N; //암호 길이
    static int M; //암호에 사용된 문자 개수
    static char[] arr; //암호에 사용된 문자 종류
    static boolean[] visited; //사용했는지 체크
    static char[] pwd; //완성된 암호 담을 배열
    static int[] cv = new int[2]; //자음 모음 사용 체크 cv[0]자음 cv[1]모음
    static HashMap<Character, Integer> vowel = new HashMap<>(); //모음 담을 해시맵
    static ArrayList<String> pwds = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new char[M];
        visited = new boolean[M];
        pwd = new char[N];

        vowel.put('a', 0);
        vowel.put('e', 0);
        vowel.put('i', 0);
        vowel.put('o', 0);
        vowel.put('u', 0);

        for(int i=0; i<M; i++) {
            arr[i] = sc.next().charAt(0);
        }

        tracking(0);

        //암호 정렬
        Collections.sort(pwds);

        for(String password : pwds) {
            sb.append(password);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void tracking(int cnt) {
        if(cnt == N) {
            // 자음 2개 모음 1개 없으면 리턴
            if(cv[0] < 2 || cv[1] < 1) return;

            for(char c : pwd)
                sb.append(c);

            //리스트에 암호 넣고
            pwds.add(String.valueOf(sb));

            //StringBuilder 초기화
            sb.setLength(0);

            return;
        }

        for(int i=0; i<M; i++) {
            // 현재 문자
            char now = arr[i];

            // 이미 사용한 문자인지 체크
            if(visited[i]) continue;
            
            // 하나 이상의 문자가 확정됐으면
            if(cnt > 0) {
                //정렬인지 체크
                int before = pwd[cnt-1];
                if(before > (int)now) continue;
            }

            //모음인지 체크
            boolean flag = isVowel(now);

            //모음이면 cv[1] 자음이면 cv[0] + 1
            if(flag) cv[1]++;
            else cv[0]++;

            //백트래킹 갔다오기
            pwd[cnt] = now;
            visited[i] = true;
            tracking(cnt+1);
            visited[i] = false;

            //모음이면 cv[1] 자음이면 cv[0] - 1
            if(flag) cv[1]--;
            else cv[0]--;
        }
    }

    // 모음이면 true, 자음이면 false
    private static boolean isVowel(char c) {
        if(vowel.containsKey(c)) return true;
        return false;
    }
}