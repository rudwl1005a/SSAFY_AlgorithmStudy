package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/4375 )
 */
public class BJ_04375_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s;
		while ((s = br.readLine()) != null) {
			int n = Integer.parseInt(s);
			int num = 1;
			int cnt = 1;
			while (num % n != 0) {
				num = (num * 10 + 1) % n;
				cnt++;
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}
