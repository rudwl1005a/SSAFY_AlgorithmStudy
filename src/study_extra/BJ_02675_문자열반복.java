package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/2675 )
 */
public class BJ_02675_문자열반복 {
	
	static int T;
	static char[] cAry;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			cAry = st.nextToken().toCharArray();
			
			for (int i = 0; i < cAry.length; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(cAry[i]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
