package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/1152 )
 */
public class BJ_01152_단어의개수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println(st.countTokens());
	}

}
