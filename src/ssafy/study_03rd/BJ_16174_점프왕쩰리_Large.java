package ssafy.study_03rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/16174 )
 */
public class BJ_16174_점프왕쩰리_Large {
	// BFS로 풀기

	static int N;
	static boolean win;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { 0, 1 }; // 우 하
	static int[] dx = { 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.println(win ? "HaruHaru" : "Hing");
	}

	private static void bfs() {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int step = map[temp[0]][temp[1]];

			// 마지막 발판 -1
			if (step < 0) {
				win = true;
				return;
			}

			for (int d = 0; d < 2; d++) {
				int ny = temp[0] + dy[d] * step;
				int nx = temp[1] + dx[d] * step;

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx])
					continue;

				visit[ny][nx] = true;
				q.offer(new int[] { ny, nx });

			}
		}

	}

}
