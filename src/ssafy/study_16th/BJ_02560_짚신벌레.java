package ssafy.study_16th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2560 )
 */
public class BJ_02560_짚신벌레 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int death = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			if (i < start) // 시작날 전까지 유지됨.
				dp[i] = dp[i - 1] % 1000;
			else if (i < end) // 단순하게 증가함! 전날 + 새로 태어남
				dp[i] = (dp[i - 1] + dp[i - start]) % 1000;
			else
				dp[i] = (dp[i - 1] + dp[i - start] - dp[i - end] + 1000) % 1000;
		}

		if (N - death >= 0)
			System.out.println((dp[N] - dp[N - death] + 1000) % 1000);
		else
			System.out.println(dp[N] % 1000);

	}

}
