package study_16th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/14621 )
 */
public class BJ_14621_나만안되는연애 {

	static int N, M, ans;
	static char[] gender;
	static int[] parents;
	static Edge[] edgeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학교의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수

		// 성별 체크
		gender = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			gender[i] = st.nextToken().charAt(0);
		}

		// 간선 저장
		edgeList = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(u, v, d);
		}
		
		// kruskal 알고리즘
		Arrays.sort(edgeList);
		makeSet();
		
		int cnt = 0;
		for (Edge edge : edgeList) {
			
			if(gender[edge.u] == gender[edge.v]) { // 성별이 같으면 연결하지 않음
				continue;
			}
			
			if (union(edge.u, edge.v)) {
				ans += edge.d;
				if (++cnt == N - 1) {
					System.out.println(ans);
					return;
				}
			}
		}
		
		System.out.println(-1);
	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}

		parents[br] = ar;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int u, v, d; // u학교와 v학교가 연결되어 있으며 이 거리는 d

		public Edge(int u, int v, int d) {
			this.u = u;
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}

	}

}
