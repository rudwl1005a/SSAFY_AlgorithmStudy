package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/9020 )
 */
public class BJ_09020_골드바흐의추측 {

	static int T;
	static boolean[] prime = new boolean[10001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 에라토스테네스의 체
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int a = n / 2;
			int b = n / 2;

			// 소수 찾기
			while (true) {
				if (!prime[a] && !prime[b]) {
					sb.append(a).append(' ').append(b).append('\n');
					break;
				}
				a--;
				b++;
			}
		}
		System.out.print(sb);
	}

}
