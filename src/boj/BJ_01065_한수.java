package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S4 ( https://www.acmicpc.net/problem/1065 )
 */
public class BJ_01065_한수 {

	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 두자리수 미만이라면 답은 그 수와 같다
		if (N < 100) {
			System.out.println(N);
			return;
		}

		// 세자리수 이상이라면 한수 계산해서 더해주기
		ans = 99;
		for (int i = 100; i <= N; i++) {
			String[] num = Integer.toString(i).split("");
			if ((Integer.parseInt(num[1]) - Integer.parseInt(num[0])) == (Integer.parseInt(num[2]) - Integer.parseInt(num[1]))) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}
