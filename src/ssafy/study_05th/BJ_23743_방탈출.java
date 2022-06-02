package ssafy.study_05th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/23743 )
 */
public class BJ_23743_방탈출 {

	static int N, M;
	static int[] parent;
	static long ans;
	static Edge[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edge = new Edge[M + N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			edge[i] = new Edge(from, to, time);
		}

		// 탈출 장소를 0으로 두고 마지막 줄을 0번으로 이동하는 시간으로 둔다
		st = new StringTokenizer(br.readLine());
		int index = 1;
		for (int i = M; i < M + N; i++) {
			edge[i] = new Edge(index++, 0, Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edge, (e1, e2) -> e1.time - e2.time);

		// make-set
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		for (Edge e : edge) {
			if (union(e.from, e.to)) { // 합칠 수 있는지만 판단
				ans = ans + (long) e.time;
				cnt++;
				if (cnt == M + N) {
					break;
				}
			}
		}

		System.out.println(ans);
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
	}

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}
		parent[br] = ar;
		return true;
	}

	static class Edge {
		int from, to, time;

		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}

	}

}
