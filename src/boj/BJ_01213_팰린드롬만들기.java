package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1213 )
 */
public class BJ_01213_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int len = str.length();
		int[] alpha = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			int idx = (int) (now - 'A');
			alpha[idx]++;
		}

		int cnt = 0;
		int center = 0;
		for (int i = 0; i < 26; i++)
			if (alpha[i] % 2 != 0) {
				center = i;
				cnt++;
			}

		if (cnt > 1 || (cnt == 1 && len % 2 == 0)) {
			System.out.print("I'm Sorry Hansoo");
			return;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alpha[i] / 2; j++) {
				sb.append((char) (i + 'A'));
			}
		}
		StringBuilder sb2 = new StringBuilder(sb.toString());
		if (cnt == 1) {
			sb.append((char) (center + 'A'));
		}
		System.out.println(sb.toString() + sb2.reverse());

	}

}
