package study_06th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/22116 )
 */
public class BJ_22116_창영이와퇴근 {

	static int N;
	static long ans;
	static long[][] map;
	static long[][] min;
	static boolean[][] visit;
	static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>((v1, v2) -> Long.compare(v1.dis, v2.dis));

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new long[N][N];
		min = new long[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Long.parseLong(st.nextToken());
				min[i][j] = Long.MAX_VALUE;
			}
		}

		min[0][0] = 0;
		pq.offer(new Vertex(0, 0, min[0][0]));

		// dijkstra
		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll();

			if (visit[vertex.y][vertex.x]) {
				continue;
			}

			visit[vertex.y][vertex.x] = true;

			// 현재까지의 최대값 계산
			ans = Math.max(ans, vertex.dis);

			// 마지막에 도착하면 탈출
			if (vertex.y == N - 1 && vertex.x == N - 1) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ny = vertex.y + dy[d];
				int nx = vertex.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
					continue;
				}

				// 0,0에서 ny, nx에 올 때 까지 가장 최대의 경사를 우선순위 큐에 저장
				pq.offer(new Vertex(ny, nx, Math.max(vertex.dis, Math.abs(map[vertex.y][vertex.x] - map[ny][nx]))));
			}
		}

		System.out.println(ans);

	}

	static class Vertex {
		int y, x;
		long dis;

		public Vertex(int y, int x, long dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
	}
}
