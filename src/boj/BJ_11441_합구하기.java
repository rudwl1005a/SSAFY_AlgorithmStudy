package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/11441 )
 */
public class BJ_11441_합구하기 {

	static int N, M, sum[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력처리
		N = Integer.parseInt(br.readLine());
		sum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + n; // i까지의 합 저장
		}

		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(sum[b] - sum[a - 1]).append("\n"); // a ~ b까지의 합은 (1~b)까지의 합 - (1~a-1)까지의 합이다
		}

		System.out.println(sb);
	}

}
