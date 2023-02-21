package ssafy.study_39th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/17828 )
 */
public class BJ_17828_문자열화폐 {

	static int N, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 문자열의 길이
		X = Integer.parseInt(st.nextToken()); // 문자열의 가치

		if (X < N || X > N * 26) { // 불가능한 경우
			System.out.println("!");
			return;
		}

		StringBuilder sb = new StringBuilder();
		int len = 0;
		while (X > 26 + (N - len)) { // Z를 넣을 수 있고, 나머지를 A로 채울 수 있을 만큼이면 Z넣기
			sb.append("Z");
			X -= 26;
			len++;
		}
		if (X > (N - len)) { // 나머지를 A로 채울 수 있고 추가로 나머지가 남은 경우
			char plus = (char) (X + 'A' - (N - len));
			sb.append(plus);
			len++;
		}
		for (int i = len; i < N; i++) { // 나머지 A로 채우기
			sb.append("A");
		}

		System.out.println(sb.reverse()); // 사전 순으로 가장 앞서는 것 출력이므로 reverse
	}

}
