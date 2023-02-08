import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 실버2 스타트와링크
public class Th_14889{
    static int N; // 사람의 수
    static int min = Integer.MAX_VALUE; // 두팀 능력치 차이 최솟값
    static int[][] stats; // 능력치 배열

    static int[] start; // 스타티 팀
    static int[] link; // 링크 팀

    static boolean[] team; // 어느팀인지 확인하는 배열 true == 스타트팀, false == 링크팀

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        start = new int[N/2];
        link = new int[N/2];
        team = new boolean[N];

        stats = new int[N][N];

        // 능력치 값 할당
        for(int i=0; i<N; i++) {
            String[] read = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(read[j]);
            }
        }
        
        //팀 능력치의 차를 구하는 것이기 때문에
        //사실 스타트팀과 링크팀의 구분이 없음
        //ex) 경우 1 :  스타트 = {1,2} , 링크 = {3,4};
        //    경우 2 : 스타트 = {3,4} , 링크 = {1,2};
        //      경우 1과 경우 2의 값은 같음
        //따라서 순서 상관없이 중복없이 N개중에 M개 뽑는거랑 같다
        team[0] = true;
        
        //백트래킹 시작
        makeTeam(1,0);
        
        System.out.println(min);
    }

    private static void makeTeam(int cnt, int prev) {
        //스타트님 다 뽑았을 경우
        if(cnt == N/2) {
            
            int idx = 0;
            //스타트팀이 아닌 사람들 링크팀으로
            for(int i=0; i<N; i++)
                if(!team[i]) link[idx++] = i;

            //최솟값이랑 비교
            min = Math.min(min, Math.abs(getStat(start) - getStat(link)));

            return;
        }

        for(int i=1; i<N; i++) {
            //이전에 뽑힌 수보다 더 낮거나 같으면 넘어가기
            if(i <= prev) continue;
            
            team[i] = true;
            start[cnt] = i;
            makeTeam(cnt+1, i);
            team[i] = false;
        }
    }

    // 팀 능력치 구하기
    private static int getStat(int[] team) {
        int teamStat = 0;

        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                teamStat += stats[team[i]][team[j]] + stats[team[j]][team[i]];
            }
        }

        return teamStat;
    }
}