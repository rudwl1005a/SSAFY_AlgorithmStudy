package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/11659 )
 */
public class BJ_11659_구간합구하기4 {

	static int N, M, sum[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sum = new int[N + 1];
		sum[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// (a부터 b까지의 합)은 (0부터 b까지의 합) - (0부터 a-1까지의 합)과 같다
			sb.append(sum[b] - sum[a - 1]).append("\n");
		}
		System.out.println(sb);

	}

}
