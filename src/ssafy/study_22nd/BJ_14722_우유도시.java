package ssafy.study_22nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/14722 )
 */
public class BJ_14722_우유도시 {

	static int N, max, map[][], dp[][][];

	static int[] dy = { 1, 0 }; // 남 동
	static int[] dx = { 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		// 0:딸기, 1:초코, 2:바나나
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int milk = map[i][j]; // 현재 위치의 우유

				// 우유 마시는 순서: 딸기(0) -> 초코(1) -> 바나나(2)
				if (milk == 0) {
					// 이전 순서의 바나나(2)를 최근으로 마신 개수 + 1
					dp[i][j][0] = Math.max(dp[i][j - 1][2] + 1, dp[i - 1][j][2] + 1);
				} else {
					dp[i][j][0] = Math.max(dp[i][j - 1][0], dp[i - 1][j][0]);
				}

				// 추가 조건식: 우유 마시는 순서 지키기 위함 (해당 현재 우유 currentMilk 를 마셔도 되는지 확인)
				if (milk == 1 && dp[i][j][0] > dp[i][j][1]) { // 이전에 딸기(0)를 먹었는지
					// 이전 순서의 딸기(0)를 최근으로 마신 개수 + 1
					dp[i][j][1] = Math.max(dp[i][j - 1][0] + 1, dp[i - 1][j][0] + 1);
				} else {
					dp[i][j][1] = Math.max(dp[i][j - 1][1], dp[i - 1][j][1]);
				}

				if (milk == 2 && dp[i][j][1] > dp[i][j][2]) { // 이전에 초코(1)를 먹었는지
					// 이전 순서의 초코(1)를 최근으로 마신 개수 + 1
					dp[i][j][2] = Math.max(dp[i][j - 1][1] + 1, dp[i - 1][j][1] + 1);
				} else {
					dp[i][j][2] = Math.max(dp[i][j - 1][2], dp[i - 1][j][2]);
				}
			}
		}

		max = Math.max(dp[N][N][0], Math.max(dp[N][N][1], dp[N][N][2]));

		System.out.println(max);

	}

}
