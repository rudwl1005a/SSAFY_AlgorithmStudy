package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B1 ( https://www.acmicpc.net/problem/1259 )
 */
public class BJ_01259_팰린드롬수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("0")) {
				break;
			}
			char[] c = s.toCharArray();
			int cnt = 0;
			for (int i = 0; i < c.length / 2; i++) {
				if (c[i] == c[c.length - i - 1]) {
					cnt++;
				}
			}
			System.out.println(cnt == c.length/2 ? "yes" : "no");
		}

	}

}
