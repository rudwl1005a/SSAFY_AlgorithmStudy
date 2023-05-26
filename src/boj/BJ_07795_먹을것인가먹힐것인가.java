package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/7795 )
 */
public class BJ_07795_먹을것인가먹힐것인가 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(B);
			int result = 0;

			for (int j = 0; j < N; j++) {
				int left = 0;
				int right = M - 1;
				int index = 0;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (B[mid] < A[j]) {
						left = mid + 1;
						index = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				result += index;
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

}
