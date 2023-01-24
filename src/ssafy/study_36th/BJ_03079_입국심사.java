package ssafy.study_36th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/3079 )
 */ 
public class BJ_03079_입국심사 {

	static int N, M, arr[], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 심사대 수
		M = Integer.parseInt(st.nextToken()); // 사람 수

		arr = new int[N]; // 심사대에서 심사를 하는 시간 저장
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]); // 심사 시간 최대값 저장
		}

		// 이분탐색
		long left = 0L;
		long right = max * (long) M; // 최대값은 심사시간 최대값 * 심사받을 사람 수
		long ans = Long.MAX_VALUE;
		while (left <= right) {
			long mid = (left + right) / 2;
			long people = 0; // mid시간일때 입국심사 통과할 수 있는 사람 수
			for (int i = 0; i < N; i++) {
				people += (mid / arr[i]); // 각 심사대를 통과한 사람 수를 모두 더한 값 저장
			}
			if (people >= M) { // M보다 같거나 크면 정답이 될 수 있음
				ans = Math.min(ans, mid); // 정답 될 수 있는 값중 최소값
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(ans);
	}

}
