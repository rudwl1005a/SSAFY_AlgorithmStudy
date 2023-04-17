package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/3273 )
 */
public class BJ_03273_두수의합 {

	static int N, X, ans, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		// 투포인터
		int left = 0, right = N - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == X) { // 같다면 ++
				ans++;
				left++;
				right--;
			} else if (sum > X) { // 크다면
				right--;
			} else { // 작다면
				left++;
			}
		}

		System.out.println(ans);
	}

}
