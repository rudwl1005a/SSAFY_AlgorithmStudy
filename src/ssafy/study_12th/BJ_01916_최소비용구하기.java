package ssafy.study_12th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1916 )
 */
public class BJ_01916_최소비용구하기 {

	static int N, M;
	static int[][] map;

	// dijkstra
	static final int INF = 1000 * 100000 + 1;
	static int[] dist;
	static boolean[] visit;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.dist - v2.dist);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 출발지
			int b = Integer.parseInt(st.nextToken()); // 도착지
			int d = Integer.parseInt(st.nextToken()); // 거리
			map[a][b] = Math.min(map[a][b], d);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 구간 출발점
		int end = Integer.parseInt(st.nextToken()); // 구간 도착점

		// dijkstra
		dist = new int[N + 1];
		visit = new boolean[N + 1];

		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.offer(new Vertex(start, dist[start]));

		while (!pq.isEmpty()) {
			Vertex v = pq.poll();

			if (visit[v.n]) {
				continue;
			}

			visit[v.n] = true;
			if (v.n == end) {
				System.out.println(dist[end]);
				break;
			}

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && map[v.n][i] != INF && dist[i] > dist[v.n] + map[v.n][i]) {
					dist[i] = dist[v.n] + map[v.n][i];
					pq.offer(new Vertex(i, dist[i]));
				}
			}
		}
	}

	static class Vertex {
		int n, dist;

		public Vertex(int n, int dist) {
			this.n = n;
			this.dist = dist;
		}

	}
}
