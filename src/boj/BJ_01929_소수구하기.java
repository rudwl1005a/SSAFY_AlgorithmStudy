package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1929 )
 */
public class BJ_01929_소수구하기 {

	static int M, N;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 에라토스테네스의 체
		prime = new boolean[N + 1];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime[i]) continue;
			for (int j = i * i; j <= N; j += i) {
				prime[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!prime[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
