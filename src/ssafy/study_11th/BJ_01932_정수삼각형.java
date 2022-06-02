package ssafy.study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1932 )
 */
public class BJ_01932_정수삼각형 {

	static int N, ans;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		 *    0
		 *   0 1 -> map[i-1][j-1]과 map[i-1][j]비교 큰것 넣기,  index벗어나거나 -1이면 비교 안함
		 *  0 1 2
		 * 0 1 2 3 
		 */

		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][0] = map[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j - 1 >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + map[i][j]);
				}
				if (map[i - 1][j] != -1) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + map[i][j]);
				}
			}
		}

		// 맨 밑에 줄에서 가장 큰 값 찾기
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[N - 1][i]);
		}
		System.out.println(ans);
	}

}
