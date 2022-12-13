package ssafy.study_31st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1669 )
 */
public class BJ_01669_멍멍이쓰다듬기 {

	static int x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		if (x == y) {
			System.out.println(0);
			return;
		}

		/*
		 * 1 - 1
		 * 4 - 1 2 1
		 * 9 - 1 2 3 2 1
		 * 16 - 1 2 3 4 3 2 1
		 * 제곱수일때 산 모양의 수열 -> 2n-1일이 필요함
		 */

		int diff = y - x;
		long n = 0;

		// 둘의 차이보다 작은 제곱수 구하기
		while (n * n < diff) {
			n++;
		}
		n = (n * n == diff) ? n : n - 1; // 제곱수가 둘의 차이와 같다면 그대로, 아니라면 한단계 아래

		long ans = 2 * n - 1; // 먼저 제곱수일때 필요한 일 수

		// 남은 차이 계산
		diff -= n * n;
		while (diff > 0) {
			diff -= Math.min(n, diff); // 수열 내 최대값 n과 둘의 차이 diff중에 작은값을 빼면서 진행
			ans++;
		}

		System.out.println(ans);
	}

}
