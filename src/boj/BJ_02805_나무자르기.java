package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/2805 )
 */
public class BJ_02805_나무자르기 {

	static int N, M, arr[];
	static long max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		long start = 0;
		long end = max;
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (int n : arr) {
				if (n > mid) {
					sum += n - mid;
				}
			}

			if (sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(end);
	}
}
