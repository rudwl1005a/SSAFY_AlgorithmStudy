package ssafy.study_09th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/13199 )
 */
public class BJ_13199_치킨먹고싶다 {

	static int T, P, M, F, C;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			P = Integer.parseInt(st.nextToken()); // 치킨 가격
			M = Integer.parseInt(st.nextToken()); // 치킨에 쓸 돈
			F = Integer.parseInt(st.nextToken()); // 필요 쿠폰 개수
			C = Integer.parseInt(st.nextToken()); // 주는 쿠폰 개수

			int duyung = M / P + (M / P * C) / F;
			int sangun = M / P;
			int coupon = M / P * C;
			if (coupon >= F) {
				sangun += (coupon - F) / (F - C) + 1;
			}
			sb.append(sangun - duyung).append("\n");
		}
		System.out.println(sb);
	}

}