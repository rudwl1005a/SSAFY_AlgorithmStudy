package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1654 )
 */
public class BJ_01654_랜선자르기 {

	static int K, N, max, input[];
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken()); // 기존 랜선 갯수
		N = Integer.parseInt(st.nextToken()); // 만들어야 할 랜선 갯수

		input = new int[K];
		for (int i = 0; i < K; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
		}

		// 이분 탐색
		long left = 1;
		long right = max;
		while (left <= right) {
			long mid = (left + right) / 2;
			int now = 0;

			for (int i = 0; i < K; i++) {
				now += input[i] / mid;
			}

			if (now >= N) {
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

}
