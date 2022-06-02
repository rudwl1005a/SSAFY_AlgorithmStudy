package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1806 )
 */
public class BJ_01806_부분합 {

	static int N, S, sum, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		ans = Integer.MAX_VALUE;
		while (start < N) {
			if (sum < S && end != N) {
				sum += arr[end];
				end++;
			} else {
				if(sum >= S) {
					ans = Math.min(ans, (end - start));
				}
				sum -= arr[start];
				start++;
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}

}
