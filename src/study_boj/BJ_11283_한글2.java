package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B5 ( https://www.acmicpc.net/problem/11283 )
 */
public class BJ_11283_한글2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c = br.readLine().charAt(0);
		System.out.println((int)(c - '가' + 1));
	}

}
