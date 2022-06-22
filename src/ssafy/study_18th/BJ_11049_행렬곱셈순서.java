package ssafy.study_18th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/11049 )
 */
public class BJ_11049_행렬곱셈순서 {

	static int N;
	static Matrix[] mat;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		mat = new Matrix[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mat[i] = new Matrix(r, c);
		}

		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		/*
		 * 점화식
		 *  dp[i][j] = i에서 j까지의 최소 행렬 곱셈
		 *  dp[i][j] = dp[i][x] + mat[i].r * mat[x].c * mat[j].c + dp[x + 1][j]
		 */

		for (int k = 1; k < N; k++) { // 구간 간격
			for (int i = 0; i + k < N; i++) { // 구간 시작점
				for (int j = i; j < i + k; j++) { // 최소 행렬 계산
					dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + mat[i].r * mat[j].c * mat[i + k].c + dp[j + 1][i + k]);
				}
			}
		}

		System.out.println(dp[0][N - 1]);
	}

	static class Matrix {
		int r, c;

		public Matrix(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
