package ssafy.study_38th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/1727 )
 */
public class BJ_01727_커플만들기 {

	static int N, M, men[], women[];
	static long dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 남자 수
		M = Integer.parseInt(st.nextToken()); // 여자 수

		men = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			men[i] = Integer.parseInt(st.nextToken());
		}

		women = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			women[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(men);
		Arrays.sort(women);

		dp = new long[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i == j) { // 같으면 무조건 커플
					dp[i][j] = dp[i - 1][j - 1] + Math.abs(men[i] - women[j]);
				} else if (i > j) { // 남자가 더 많으면 현재 남자는 커플이거나 솔로일 수 있다
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + Math.abs(men[i] - women[j]));
				} else if (i < j) { // 여자가 더 많으면 현재 여자는 커플이거나 솔로일 수 있다
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(men[i] - women[j]));
				}
			}
		}

		System.out.println(dp[N][M]);

	}

}
