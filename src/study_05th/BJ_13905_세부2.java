package study_05th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/13905 )
 */
public class BJ_13905_세부2 {
    static int parent[];
    static int N, M, S, E, ans;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1, e2) -> e2.c - e1.c);

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        set();
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(s, e, c));
        }

        while (!pq.isEmpty()) {

            Edge e = pq.poll();

            if (find(e.s) == find(e.e))
                continue;

            union(e.s, e.e);

            if (find(S) == find(E)) {
                ans = e.c; /** @See 여기서 답을 저장해서 */
                break;
            }
        }
        System.out.println(ans); /** @See 여기서 출력했더니 답 나왔습니다! */

    }

    static class Edge {

        int s;
        int e;
        int c;

        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    static void set() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int s, int e) {
        int rs = find(s);
        int re = find(e);

        parent[rs] = re; /** @See 이부분도 고쳤습니다 -> 차이는 없는것 같아요 */
    }

}
