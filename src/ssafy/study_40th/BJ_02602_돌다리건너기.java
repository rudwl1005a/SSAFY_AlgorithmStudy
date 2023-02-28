package ssafy.study_40th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2602 )
 */
public class BJ_02602_돌다리건너기 {

	static int N, M, dp[][][];
	static String word, devil, angel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = br.readLine();
		devil = br.readLine();
		angel = br.readLine();

		N = word.length(); // 문자열 길이
		M = devil.length(); // 다리의 길이

		dp = new int[2][N][M];
		// 기저조건
		if (word.charAt(0) == devil.charAt(0)) dp[0][0][0] = 1;
		if (word.charAt(0) == angel.charAt(0)) dp[1][0][0] = 1;

		/*
		 * 문자열 idx와 돌다리idx가 같다면
		 * dp[돌다리][문자열idx][돌다리idx] = dp[돌다리][문자열idx][돌다리idx-1] + dp[다른 돌다리][문자열idx-1][돌다리idx-1]
		 * 다르다면
		 * dp[돌다리][문자열idx][돌다리idx] = dp[돌다리][문자열idx][돌다리idx-1]
		 */
		for (int i = 1; i < M; i++) {

			dp[0][0][i] = word.charAt(0) == devil.charAt(i) ? dp[0][0][i - 1] + 1 : dp[0][0][i - 1];
			dp[1][0][i] = word.charAt(0) == angel.charAt(i) ? dp[1][0][i - 1] + 1 : dp[1][0][i - 1];

			for (int j = 1; j < N; j++) {

				dp[0][j][i] += word.charAt(j) == devil.charAt(i) ? dp[0][j][i - 1] + dp[1][j - 1][i - 1] : dp[0][j][i - 1];
				dp[1][j][i] += word.charAt(j) == angel.charAt(i) ? dp[1][j][i - 1] + dp[0][j - 1][i - 1] : dp[1][j][i - 1];

			}
		}

		System.out.println(dp[0][N - 1][M - 1] + dp[1][N - 1][M - 1]);
	}

//  시간초과 ver
//	// cnt : word중 몇번째, idx : 다리 몇번째 건너는지, flag : true(악마차례) false(천사차례)
//	private static void solve(int cnt, int idx, boolean flag) {
//		if (cnt == word.length()) { // word 다 채웠다면
//			ans++;
//			return;
//		}
//		if (idx == devil.length()) { // 다리 다 건넜다면
//			return;
//		}
//
//		if (flag) { // 악마 차례
//			if (devil.charAt(idx) == word.charAt(cnt)) {
//				solve(cnt + 1, idx + 1, !flag); // 현재 선택하고 넘어감
//				solve(cnt, idx + 1, flag); // 현재 선택하지않고 넘어감
//			} else {
//				solve(cnt, idx + 1, flag);
//			}
//		} else { // 천사 차례
//			if (angel.charAt(idx) == word.charAt(cnt)) {
//				solve(cnt + 1, idx + 1, !flag); // 현재 선택하고 넘어감
//				solve(cnt, idx + 1, flag); // 현재 선택하지않고 넘어감
//			} else {
//				solve(cnt, idx + 1, flag);
//			}
//		}
//	}

}
