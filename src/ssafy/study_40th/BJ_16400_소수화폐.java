package ssafy.study_40th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/16400 )
 */
public class BJ_16400_소수화폐 {

	static int N, dp[];
	static boolean isPrime[];
	static final int MOD = 123456789;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> prime = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		// 에라토스테네스의 체
		isPrime = new boolean[N + 1];
		for (int i = 2; i * i <= N; i++) {
			if (!isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}

		// 소수인것 저장
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				prime.add(i);
			}
		}

		dp = new int[N + 1];
		dp[0] = 1;
		for (int i = 0; i < prime.size(); i++) {
			for (int j = prime.get(i); j <= N; j++) {
				dp[j] = (dp[j] + dp[j - prime.get(i)]) % MOD;
			}
		}

		System.out.println(dp[N] % MOD);
	}

}
