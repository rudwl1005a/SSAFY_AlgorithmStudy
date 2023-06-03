package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9996 )
 */
public class BJ_09996_한국이그리울땐서버에접속하지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		String[] str = input.split("\\*");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			if (tmp.length() < input.length() - 1) {
				sb.append("NE\n");
				continue;
			}

			if (tmp.substring(0, str[0].length()).equals(str[0]) && tmp.substring(tmp.length() - str[1].length()).equals(str[1])) {
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}
		}
		System.out.println(sb);
	}

}
