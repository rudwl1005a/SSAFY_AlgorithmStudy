package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17425 )
 */
public class BJ_17425_약수의합 {

	static int T;
	static final int MAX = 1000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] f = new long[MAX]; // 약수들의 합
		long[] g = new long[MAX]; 

		Arrays.fill(f, 1); // 모든 수는 1을 약수로 가짐
		g[1] = f[1]; // g(1) = f(1)

		for (int i = 2; i < MAX; i++) {
			// i를 약수로 가지는 수에 +i
			for (int j = 1; j * i < MAX; j++) {
				f[j * i] += i;
			}
			// 누적 합 구하기
			g[i] = g[i - 1] + f[i];
		}

		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(g[N]).append("\n");
		}
		System.out.println(sb);
	}

}
