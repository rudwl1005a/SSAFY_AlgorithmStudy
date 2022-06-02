package ssafy.study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/12865 )
 */
public class BJ_12865_평범한배낭 {

	static int N, K;
	static int[][] item;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		item = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken()); // 물건의 무게
			item[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) { // 물건
			for (int j = 1; j <= K; j++) { // 무게
				dp[i][j] = dp[i - 1][j];
				int w = item[i][0];
				if (j >= w) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + item[i][1]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}

}
