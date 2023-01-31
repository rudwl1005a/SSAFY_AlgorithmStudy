package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1072 )
 */
public class BJ_01072_게임 {

	static int X, Y, ans;
	static long Z;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken()); // 게임 횟수
		Y = Integer.parseInt(st.nextToken()); // 이긴 게임

		Z = (100 * (long) Y) / X; // 최초 승률(%)

		ans = Integer.MAX_VALUE;
		int left = 0;
		int right = 1000000000;
		boolean flag = false; // Z가 바뀌었는지 확인
		while (left <= right) {
			int mid = (left + right) / 2; // 추가 승리횟수
			long rate = (100 * (long) (Y + mid)) / (X + mid); // mid번 이긴 후 승률(%)

			if (rate == Z) { // 승률이 그대로면 승리 횟수(mid) 더 크게
				left = mid + 1;
			} else { // 승률 바뀌면 승리 횟수(mid) 더 작게
				right = mid - 1;
				flag = true;
				ans = Math.min(ans, mid);
			}
		}

		System.out.println(flag ? ans : -1);
	}

}
