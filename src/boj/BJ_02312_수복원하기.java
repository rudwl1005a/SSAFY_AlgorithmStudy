package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2312 )
 */
public class BJ_02312_수복원하기 {

	static int T;
	static boolean prime[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		prime = new boolean[100001];
		prime[0] = prime[1] = true;
		for (int i = 2; i < 100001; i++) {
			if (!prime[i]) {
				for (int j = 2 * i; j < 100001; j += i) {
					prime[j] = true;
				}
			}
		}

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 2; i <= n; i++) {
				if (prime[i]) continue;
				int cnt = 0;
				while (n % i == 0) {
					n /= i;
					cnt++;
				}
				if (cnt != 0) {
					sb.append(i + " " + cnt).append("\n");
				}
				if (n == 0) break;
			}
		}

		System.out.println(sb);
	}

}
