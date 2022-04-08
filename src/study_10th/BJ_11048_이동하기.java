package study_10th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/11048 )
 */
public class BJ_11048_이동하기 {

	static int N, M;
	static int[][] map;
	static int[][] dp;

	static int[] dy = { -1, 0, -1 }; // 상 좌 대각
	static int[] dx = { 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cost = Integer.MIN_VALUE;
				for (int d = 0; d < 3; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
						continue;
					}
					cost = Math.max(cost, dp[ny][nx]);

					dp[i][j] = cost + map[i][j];
				}
			}
		}

		System.out.println(dp[N - 1][M - 1]);
	}

}
