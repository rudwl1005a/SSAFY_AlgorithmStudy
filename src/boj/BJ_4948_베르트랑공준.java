package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4948_베르트랑공준 {

	public static boolean[] prime = new boolean[246913];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 에라토스테네스의 체
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!prime[i]) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
