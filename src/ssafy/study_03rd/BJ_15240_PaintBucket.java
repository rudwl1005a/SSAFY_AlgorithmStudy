package ssafy.study_03rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/15240 )
 * 시간 : 532ms
 */
public class BJ_15240_PaintBucket {
	// BFS로 풀기

	static int N, M, Y, X; // 행, 열, 초기 행, 초기 열
	static char C, initC; // 칠해야 할 색깔, 초기 색깔
	static char[][] map;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		C = st.nextToken().charAt(0);
		initC = map[Y][X];

		bfs(Y, X);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int y, int x) {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { y, x });
		map[y][x] = C;
		visit[y][x] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = temp[0] + dy[d];
				int nx = temp[1] + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] != initC)
					continue;

				map[ny][nx] = C;
				visit[ny][nx] = true;
				q.offer(new int[] { ny, nx });
			}
		}

	}

}
