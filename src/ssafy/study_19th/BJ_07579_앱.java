package ssafy.study_19th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/7579 )
 */
public class BJ_07579_앱 {

	static int N, M;
	static int[] memory, cost;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memory = new int[N + 1];
		cost = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
		}

		dp = new int[N + 1][10001]; // dp[i][j] : i번째 앱까지 사용했을 때, j비용으로 사용 가능한 최대 메모리의 크기 / 비용 최대 100*100

		// knapsack 알고리즘
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10001; j++) {
				if (j < cost[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
			}
		}

		// 최대 메모리 M보다 큰 비용 i찾기
		for (int i = 1; i < 10001; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				return;
			}
		}

	}

}
