package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1753 )
 */
public class BJ_01753_최단경로 {

	static int V, E, K;
	static ArrayList<ArrayList<Vertex>> vertex = new ArrayList<ArrayList<Vertex>>();
	static boolean[] visit;
	static int[] dist; // 비용
	static PriorityQueue<Vertex> pq = new PriorityQueue<>();
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visit = new boolean[V + 1];
		dist = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			vertex.add(new ArrayList<Vertex>());
			dist[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			vertex.get(u).add(new Vertex(v, w));
		}

		dijkstra();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra() {
		dist[K] = 0;
		pq.offer(new Vertex(K, 0));

		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			if (visit[v.n]) {
				continue;
			}
			visit[v.n] = true;

			// ne 의 비용 체크
			for (Vertex ne : vertex.get(v.n)) {
				if (!visit[ne.n] && dist[ne.n] > ne.d + dist[v.n]) {
					dist[ne.n] = ne.d + dist[v.n];
					pq.offer(new Vertex(ne.n, dist[ne.n]));
				}
			}

		}
	}

	static class Vertex implements Comparable<Vertex> {
		int n, d;

		public Vertex(int n, int dist) {
			this.n = n;
			this.d = dist;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.d - o.d;
		}

	}

}
