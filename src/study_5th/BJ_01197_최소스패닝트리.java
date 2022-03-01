package study_5th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1197 )
 */
public class BJ_01197_최소스패닝트리 {

	static int V, E, ans;
	static Edge[] edge;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		// 간선 리스트 만들기
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(from, to, cost);
		}

		Arrays.sort(edge, (e1, e2) -> e1.cost - e2.cost);

		// make-set
		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		for (Edge e : edge) {
			if(union(e.from, e.to)) {
				ans += e.cost;
				cnt++;
				if(cnt == V - 1) {
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
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

	}

}
