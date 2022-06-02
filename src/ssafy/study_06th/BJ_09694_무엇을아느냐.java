package ssafy.study_06th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/9694 )
 */
public class BJ_09694_무엇을아느냐 {

	static int T, N, M;
	static int[][] map;
	static int[] dist;
	static int[] meet; // 바로 직전에 만났던 사람
	static boolean[] visit;

	static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.dis - v2.dis);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 관계의 개수
			M = Integer.parseInt(st.nextToken()); // 정치인의 수
			map = new int[M][M];
			dist = new int[M];
			meet = new int[M];
			visit = new boolean[M];
			pq.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				map[from][to] = dis;
				map[to][from] = dis;
			}

			sb.append("Case #").append(t).append(": ");

			// dijkstra
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[0] = 0;
			meet[0] = 0;
			pq.offer(new Vertex(0, dist[0]));

			while (!pq.isEmpty()) {
				Vertex v = pq.poll();

				if (visit[v.n]) {
					continue;
				}

				visit[v.n] = true;

				if (v.n == M - 1) {
					break;
				}

				for (int i = 0; i < M; i++) {
					if (!visit[i] && map[v.n][i] != 0 && dist[v.n] + map[v.n][i] < dist[i]) {
						dist[i] = dist[v.n] + map[v.n][i];
						meet[i] = v.n;
						pq.offer(new Vertex(i, dist[i]));
					}
				}
			}

			String ans = Integer.toString(M - 1);
			if (dist[M - 1] == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			} else {
				int start = M - 1;
				while (true) {
					int prev = meet[start];
					ans = Integer.toString(prev) + " " + ans;
					if (prev == 0) {
						break;
					}
					start = prev;
				}
				sb.append(ans).append("\n");
			}
		}
		System.out.println(sb);
	}

	static class Vertex {
		int n, dis;

		public Vertex(int n, int dis) {
			this.n = n;
			this.dis = dis;
		}

	}
}
