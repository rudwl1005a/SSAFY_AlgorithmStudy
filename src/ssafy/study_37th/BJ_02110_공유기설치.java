package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2110 )
 */
public class BJ_02110_공유기설치 {

	static int N, C, home[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집의 개수
		C = Integer.parseInt(st.nextToken()); // 공유기 개수

		home = new int[N]; // 집의 위치
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		// 이분탐색
		int left = 0;
		int right = 1000000000;
		int dist = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int start = home[0]; // 첫번째 집
			int cnt = 1; // 공유기를 설치할 수 있는 개수
			for (int i = 1; i < N; i++) {
				dist = home[i] - start;
				if (dist >= mid) { // 공유기 설치할 수 있다면
					cnt++;
					start = home[i]; // 시작점 현재로
				}
			}

			if (cnt >= C) { // 공유기 설치 할 수 있는 개수가 C보다 많다면 정답이 될 수 있다.
				ans = Math.max(ans, mid); // 그중 최대값 저장
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

}
