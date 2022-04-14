package study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/9251 )
 */
public class BJ_09251_LCS {

	static String str1, str2;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine();
		str2 = br.readLine();

		int len1 = str1.length();
		int len2 = str2.length();

		dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[len1][len2]);
	}

}
