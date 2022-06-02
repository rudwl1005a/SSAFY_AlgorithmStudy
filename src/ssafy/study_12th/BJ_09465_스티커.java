package ssafy.study_12th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/9465 )
 */
public class BJ_09465_스티커 {

	static int T, N;
	static int[][] map;
	static int[][] dp;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp = new int[2][N + 1];
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 2] + map[0][i], dp[1][i - 1] + map[0][i]);
				dp[1][i] = Math.max(dp[0][i - 2] + map[1][i], dp[0][i - 1] + map[1][i]);
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}

	}

}
