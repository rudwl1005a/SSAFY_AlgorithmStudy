package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1753 )
 */
public class BJ_01753_최단경로_메모리초과 {

	static int V, E, K;
	static final int INF = 3000001;
	static int[][] map;

	static int[] dist;
	static boolean[] visit;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점개수
		E = Integer.parseInt(st.nextToken()); // 간선개수
		K = Integer.parseInt(br.readLine()); // 시작정점

		map = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (map[u][v] == 0) {
				map[u][v] = w;
			} else {
				map[u][v] = Math.min(map[u][v], w);
			}
		}

		dist = new int[V + 1];
		visit = new boolean[V + 1];
		
		Arrays.fill(dist, INF);
		dist[K] = 0;
		pq.offer(new Vertex(K, 0));

		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			
			if(visit[v.n]) {
				continue;
			}
			
			visit[v.n] = true;
			
			for (int i = 1; i <= V; i++) {
				if(!visit[i] && map[v.n][i] != 0 && dist[i] > dist[v.n] + map[v.n][i]) {
					dist[i] = dist[v.n] + map[v.n][i];
					pq.offer(new Vertex(i, dist[i]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);

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
