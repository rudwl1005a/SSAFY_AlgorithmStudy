package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B1 ( https://www.acmicpc.net/problem/1157 )
 */
public class BJ_01157_단어공부 {

	static int[] alpabet = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				alpabet[s.charAt(i) - 'A']++;
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				alpabet[s.charAt(i) - 'a']++;
			}
		}

		int max = Integer.MIN_VALUE;
		char ans = '?';
		for (int i = 0; i < 26; i++) {
			if (max < alpabet[i]) {
				max = alpabet[i];
				ans = (char) ('A' + i);
			} else if (max == alpabet[i]) {
				ans = '?';
			}
		}

		System.out.println(ans);
	}

}
