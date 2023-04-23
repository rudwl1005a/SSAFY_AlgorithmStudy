package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1107 )
 */
public class BJ_01107_리모컨 {

	static int N, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<Integer>();
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				list.add(n);
			}
		}

		ans = Math.abs(100 - N); // +,- 으로만 움직였을 때

		int min = 987654321;
		int cnt = 0;
		for (int i = 0; i <= 999999; i++) { // 완전 탐색
			String now = String.valueOf(i);
			boolean flag = true;
			for (int k = 0; k < now.length(); k++) {
				if (list.contains(now.charAt(k) - '0')) { // 고장난 버튼
					flag = false;
					break;
				}
			}
			if (!flag) {
				continue;
			}

			cnt = now.length() + Math.abs(i - N);
			if (cnt < min) {
				min = cnt;
			}

		}

		if (min < ans) {
			ans = min;
		}
		System.out.println(ans);
	}

}
