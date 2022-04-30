package study_13th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/17070 )
 */
public class BJ_17070_파이프옮기기1 {

	static int N, ans;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[3][N][N]; // 0:가로, 1:세로, 2:대각
		dp[0][0][1] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] == 1) { // 벽이면 체크 안함
					continue;
				}

				// 가로 : 전에 놨던 파이프가 가로, 대각일때만 가능
				dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];

				// 세로 : 전에 놨던 파이프가 세로, 대각일때만 가능
				if (i != 0) {
					dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
				}

				// 대각선 : 전에 놨던 파이프 상관없이 놓을 수 있고, 대각이 벽이 아니였으면 놓을 수 있음
				if (i != 0 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
					dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
				}
			}
		}

		System.out.println(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1]);

	}

}
