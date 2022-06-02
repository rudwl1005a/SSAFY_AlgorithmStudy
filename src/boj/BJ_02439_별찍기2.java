package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B3 ( https://www.acmicpc.net/problem/2439 )
 */
public class BJ_02439_별찍기2 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = "";
			for (int j = 0; j < N - i - 1; j++) {
				s += " ";
			}
			for (int j = N - i - 1; j < N; j++) {
				s += "*";				
			}
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

}
