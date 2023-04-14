package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/17413 )
 */
public class BJ_17413_단어뒤집기2 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		boolean flag = false;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				while (!st.empty()) { // '<' 이전 문자열 거꾸로 출력
					sb.append(st.pop());
				}
				flag = true;
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				flag = false;
				sb.append(s.charAt(i));
			} else if (flag) { // <> 안의 문자는 그대로 출력
				sb.append(s.charAt(i));
			} else {
				if (s.charAt(i) == ' ') { // '공백' 이전 문자열 거꾸로 출력
					while (!st.empty()) {
						sb.append(st.pop());
					}
					sb.append(s.charAt(i));
				} else {
					st.push(s.charAt(i));
				}
			}

		}

		while (!st.empty()) {
			sb.append(st.pop());
		}

		System.out.println(sb);
	}
}
