package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2512 )
 */
public class BJ_02512_예산 {

	static int N, budget[], M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 지방의 수
		budget = new int[N]; // 지방 예산 요청 값
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine()); // 국가 총 예산

		int temp = 0;
		for (int i = 0; i < N; i++) {
			temp += budget[i];
			ans = Math.max(ans, budget[i]);
		}

		// 1. 모든 요청이 배정될 수 있는 경우 요청한 금액 그대로 배정
		if (temp <= M) {
			System.out.println(ans); // 예산들 중 최대값 정수 출력
			return;
		}

		// 2. 요청 배정될 수 없는 경우
		ans = Integer.MIN_VALUE;
		int left = 0;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			// 예산 합 계산
			for (int i = 0; i < N; i++) {
				if (budget[i] <= mid) {
					sum += budget[i];
				} else {
					sum += mid;
				}
			}

			if (sum <= M) { // 예산 가능하다면 최대값 갱신
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

}
