package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2470 )
 */
public class BJ_02470_두용액 {

	static int N, nums[], ans1, ans2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		// 투포인터
		int left = 0;
		int right = N - 1;
		int diff = Integer.MAX_VALUE;
		while (left < right) {
			int absDiff = Math.abs(nums[left] + nums[right]); // 두 수의 차이
			if (absDiff < diff) { // 0에 더 가까우면 정답 갱신
				diff = absDiff;
				ans1 = nums[left];
				ans2 = nums[right];
			}
			if (nums[left] + nums[right] > 0) {
				right--;
			} else {
				left++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}

}
