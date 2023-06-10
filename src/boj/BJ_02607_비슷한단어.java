package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2607 )
 */
public class BJ_02607_비슷한단어 {

	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[] alpha = new int[26];
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int idx = (int) (c - 'A');
			alpha[idx]++;
		}

		for (int i = 0; i < N - 1; i++) {
			String now = br.readLine();

			if (Math.abs(now.length() - word.length()) > 1) continue;

			int cnt = 0; // 같은 알파벳 개수
			int[] check = alpha.clone();

			// 비교할 문자열의 알파벳 비교
			for (int j = 0; j < now.length(); j++) {
				int idx = now.charAt(j) - 'A';

				if (check[idx] > 0) {
					cnt++;
					check[idx]--;
				}
			}

			if (word.length() - 1 == now.length()) {
				if (cnt == now.length()) ans++;
			} else if (word.length() + 1 == now.length()) {
				if (cnt == word.length()) ans++;
			} else if (word.length() == now.length()) {
				if (cnt == word.length()) ans++;
				else if (cnt == word.length() - 1) ans++;
			}
		}

		System.out.println(ans);
	}

}
