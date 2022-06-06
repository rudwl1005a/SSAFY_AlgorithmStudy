package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2467 )
 */
public class BJ_02467_용액 {

	static int N, start, end, min;
	static int[] sol, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sol = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sol[i] = Integer.parseInt(st.nextToken());
		}

		ans = new int[2];
		end = N - 1;
		min = Integer.MAX_VALUE;

		while (start < end) {
			// 두 용액의 합의 최솟값 갱신
			if (Math.abs(sol[start] + sol[end]) < min) {
				min = Math.abs(sol[start] + sol[end]);
				ans[0] = sol[start];
				ans[1] = sol[end];
			}

			if (sol[start] + sol[end] < 0) { // 합이 0보다 작으면 왼쪽포인터 이동
				start++;
			} else { // 합이 0보다 크다면 오른쪽포인터 이동
				end--;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans[0]).append(" ").append(ans[1]);
		System.out.println(sb);

	}

}
