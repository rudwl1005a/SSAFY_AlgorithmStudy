package study_13th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2206 )
 */
public class BJ_02206_벽부수고이동하기 {

	static int N, M, min;
	static char[][] map;
	static boolean[][][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		min = Integer.MAX_VALUE;

		bfs();

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[2][N][M];

		q.offer(new Node(0, 0, false, 1));
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.y == N - 1 && node.x == M - 1) {
				min = Math.min(min, node.n);
			}

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				// 범위 체크
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
					continue;
				}

				// 방문 체크
				if (node.broke && visit[1][ny][nx]) {
					continue;
				}
				if (!node.broke && visit[0][ny][nx]) {
					continue;
				}

				// 벽 부쉈는지 체크
				if (node.broke && map[ny][nx] == '1') { // 한번 벽을 부셨으면 벽이있었을때는 가지 않는다
					continue;
				}

				if(node.broke) {
					visit[1][ny][nx] = true;
				} else {
					visit[0][ny][nx] = true;
				}
				
				if (map[ny][nx] == '1') { // 벽을 부셨으면
					q.offer(new Node(ny, nx, true, node.n + 1));
				} else if (map[ny][nx] == '0') { // 벽이 아니였으면
					q.offer(new Node(ny, nx, node.broke, node.n + 1));
				}
			}
		}

	}

	static class Node {
		int y, x;
		boolean broke;
		int n;

		public Node(int y, int x, boolean broke, int n) {
			super();
			this.y = y;
			this.x = x;
			this.broke = broke;
			this.n = n;
		}
	}
}
