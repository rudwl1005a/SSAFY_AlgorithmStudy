package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B3 ( https://www.acmicpc.net/problem/2438 )
 */
public class BJ_02438_별찍기1 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String s = "";
		for (int i = 0; i < N; i++) {
			s += "*";
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

}
