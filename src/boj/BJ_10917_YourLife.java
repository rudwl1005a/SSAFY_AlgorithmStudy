package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 S2 ( https://www.acmicpc.net/problem/10917 )
 * 그래프 이론, 그래프 탐색, 너비 우선 탐색
 */
public class BJ_10917_YourLife {

    static int N, M, visited[];
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(y).add(x);
            graph.get(x).add(y);
        }

        findDreamBFS();

        bw.write(visited[N] >= 0 ? visited[N]+"" : "-1");

        bw.flush();
        bw.close();
    }

    private static void findDreamBFS() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int n : graph.get(node)) {
                if(visited[n] == -1) {
                    queue.offer(n);
                    visited[n] = visited[node] + 1; // 이전 상황의 변화 수 + 1
                }
            }
        }
    }

}
