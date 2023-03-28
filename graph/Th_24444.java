package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444_알고리즘수업너비우선탐색1 {

    static int order = 1;
    static int[] orderArr;
    static boolean[] isVisited;

    static ArrayList<ArrayList<Integer>> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfVer = Integer.parseInt(st.nextToken());
        int numOfEdge = Integer.parseInt(st.nextToken());
        int startVer = Integer.parseInt(st.nextToken());
        orderArr = new int[numOfVer + 1];
        isVisited = new boolean[numOfVer + 1];

        edgeList = new ArrayList<>();
        for(int i=0; i<=numOfVer; i++) {
            edgeList.add(new ArrayList<>());
        }

        for(int i=0; i<numOfEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int ver1 = Integer.parseInt(st.nextToken());
            int ver2 = Integer.parseInt(st.nextToken());

            edgeList.get(ver1).add(ver2);
            edgeList.get(ver2).add(ver1);
        }

        for(int i=1; i<=numOfVer; i++) {
            Collections.sort(edgeList.get(i));
        }

        BFS(startVer);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=numOfVer; i++) {
            sb.append(orderArr[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        isVisited[start] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            if(orderArr[cur] == 0) {
                orderArr[cur] = order++;
            }

            for(Integer num : edgeList.get(cur)) {
                if(isVisited[num]) continue;
                isVisited[num] = true;
                que.offer(num);
            }
        }
    }
}