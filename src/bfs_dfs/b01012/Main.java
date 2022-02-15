package bfs_dfs.b01012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1012 )
 * 시간 : 172ms
 */
public class Main {
	// BFS로 풀기

	static int T, N, M, K, count;
	static boolean[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			count = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			bfs();

			System.out.println(count);
		}
	}

	private static void bfs() {
		// 초기화
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j] || visit[i][j])
					continue;

				visit[i][j] = true;
				q.offer(new Node(i, j));

				while (!q.isEmpty()) {
					Node node = q.poll();

					for (int d = 0; d < 4; d++) {
						int ny = node.y + dy[d];
						int nx = node.x + dx[d];

						if (ny < 0 || nx < 0 || ny >= N || nx >= M || !map[ny][nx] || visit[ny][nx])
							continue;
						
						visit[ny][nx] = true;
						q.offer(new Node(ny, nx));
					}
				}

				count++;
			}
		}

	}

}
