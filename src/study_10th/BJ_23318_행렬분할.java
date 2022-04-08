package study_10th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/23318 )
 */
public class BJ_23318_행렬분할 {

	static int N, M, A, B, min, max;
	static int[][] map;
	static int[][] dp;

	// 조합
	static int[] row;
	static int[] col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					dp[i][j] = map[i][j];
				} else {
					dp[i][j] += dp[i][j - 1] + map[i][j];
				}
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] += dp[i - 1][j];
			}
		}

		min = Integer.MAX_VALUE; // 정답

		row = new int[A + 2];
		row[0] = -1;
		row[A + 1] = N - 1;
		col = new int[B + 2];
		col[0] = -1;
		col[B + 1] = M - 1;

		combRow(1, 0);

		System.out.println(min);
	}

	private static void combRow(int cnt, int start) { // 행 조합

		if (cnt == A + 1) {
			combCol(1, 0);
			return;
		}

		for (int i = start; i < N - 1; i++) {
			row[cnt] = i;
			combRow(cnt + 1, i + 1);
		}
	}

	private static void combCol(int cnt, int start) { // 열 조합

		if (cnt == B + 1) {
			// 각 구간 합 계산
			max = Integer.MIN_VALUE;
			for (int i = 1; i <= A + 1; i++) {
				for (int j = 1; j <= B + 1; j++) {
					int y1 = row[i - 1] + 1;
					int x1 = col[j - 1] + 1;
					int y2 = row[i];
					int x2 = col[j];
					max = Math.max(max, sum(y1, x1, y2, x2));
				}
			}
			min = Math.min(min, max);
			return;
		}

		for (int i = start; i < M - 1; i++) {
			col[cnt] = i;
			combCol(cnt + 1, i + 1);
		}
	}

	static int sum(int y1, int x1, int y2, int x2) {
		if (y1 == 0 && x1 == 0) {
			return dp[y2][x2];
		} else if (y1 == 0 && x1 != 0) {
			return dp[y2][x2] - dp[y2][x1 - 1];
		} else if (y1 != 0 && x1 == 0) {
			return dp[y2][x2] - dp[y1 - 1][x2];
		}
		return dp[y2][x2] - dp[y2][x1 - 1] - dp[y1 - 1][x2] + dp[y1 - 1][x1 - 1];
	}

}
