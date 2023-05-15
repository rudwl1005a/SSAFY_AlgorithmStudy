package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2589 )
 */
public class BJ_02589_보물섬 {

	static int N, M, ans;
	static char map[][];
	static boolean visit[][];

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'W') continue;
				int len = bfs(i, j);
				ans = Math.max(ans, len);
			}
		}

		System.out.println(ans);
	}

	private static int bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[N][M];

		visit[i][j] = true;
		q.offer(new Node(i, j, 0));

		int len = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = now.y + dy[d];
				int nx = now.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 'W') continue;

				visit[ny][nx] = true;
				len = Math.max(len, now.cnt + 1);
				q.offer(new Node(ny, nx, now.cnt + 1));
			}
		}

		return len;
	}

	static class Node {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

}
