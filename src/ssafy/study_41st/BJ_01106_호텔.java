package ssafy.study_41st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1106 )
 */
public class BJ_01106_호텔 {

	static int C, N, dp[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken()); // 늘려야하는 고객 수
		N = Integer.parseInt(st.nextToken()); // 홍보할 수 있는 도시 개수

		dp = new int[C + 101]; // 최소 달성 고객 + 최대 도시 고객
		Arrays.fill(dp, 1000 * 100 * 20);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			for (int j = people; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - people]);
			}
		}

		// 최소한 늘려야 할 고객 수 중 가장 비용이 낮은 값
		ans = Integer.MAX_VALUE;
		for (int i = C; i < C + 101; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans);
	}

}
