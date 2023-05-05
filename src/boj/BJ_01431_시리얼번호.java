package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1431 )
 */
public class BJ_01431_시리얼번호 {

	static int N;
	static String input[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new String[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}

		Arrays.sort(input, (o1, o2) -> {
			if (o1.length() - o2.length() == 0) { // 1. 길이비교
				int a = getSum(o1);
				int b = getSum(o2);
				if (a - b == 0) { // 2. 문자열에 숫자값의 합 비교
					return o1.compareTo(o2); // 3. 알파벳 순서 = 문자열 비교
				} else {
					return a - b;
				}
			} else {
				return o1.length() - o2.length();
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : input) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	public static int getSum(String s) {
		int a = 0;
		s = s.replaceAll("[^0-9]", "");
		for (char c : s.toCharArray()) {
			a += Character.getNumericValue(c);
		}
		return a;
	}
}
