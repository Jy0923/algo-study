package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1991_트리순회 {

    static HashMap<Character, Character[]> nodeMap;
    static StringBuilder preOrderStr, inOrderStr, postOrderStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        preOrderStr = new StringBuilder();
        inOrderStr = new StringBuilder();
        postOrderStr = new StringBuilder();

        nodeMap = new HashMap<>();

        String[] read;
        for(int i=0; i<N; i++) {
            read = br.readLine().split(" ");
            char parent = read[0].charAt(0);
            char left = read[1].charAt(0);
            char right = read[2].charAt(0);

            nodeMap.put(parent, new Character[2]);
            nodeMap.get(parent)[0] = left;
            nodeMap.get(parent)[1] = right;
        }

        preOrder('A');
        inOrder('A');
        postOrder('A');

        System.out.println(preOrderStr);
        System.out.println(inOrderStr);
        System.out.println(postOrderStr);
    }

    private static void preOrder(char parent) {
        preOrderStr.append(parent);

        for(int i=0; i<2; i++) {
            if(nodeMap.get(parent)[i] == '.') continue;
            preOrder(nodeMap.get(parent)[i]);
        }
    }

    private static void inOrder(char parent) {
        if(nodeMap.get(parent)[0] != '.') {
            inOrder(nodeMap.get(parent)[0]);
        }

        inOrderStr.append(parent);

        if(nodeMap.get(parent)[1] != '.') {
            inOrder(nodeMap.get(parent)[1]);
        }
    }


    private static void postOrder(char parent) {
        if(nodeMap.get(parent)[0] != '.') {
            postOrder(nodeMap.get(parent)[0]);
        }

        if(nodeMap.get(parent)[1] != '.') {
            postOrder(nodeMap.get(parent)[1]);
        }

        postOrderStr.append(parent);
    }
}
