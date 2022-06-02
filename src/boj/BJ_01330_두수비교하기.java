package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B4 ( https://www.acmicpc.net/problem/1330 )
 */
public class BJ_01330_두수비교하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if (A > B) System.out.println(">");
		else if (A < B) System.out.println("<");
		else System.out.println("==");
	}

}
