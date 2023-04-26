package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S4 ( https://www.acmicpc.net/problem/2960 )
 */
public class BJ_02960_에라토스테네스의체 {

	static int N, K;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		prime = new boolean[N + 1];

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!prime[j]) {
					cnt++;
					prime[j] = true;
				}

				if (cnt == K) {
					System.out.println(j);
					return;
				}
			}
		}

		System.out.println(-1);
	}

}
