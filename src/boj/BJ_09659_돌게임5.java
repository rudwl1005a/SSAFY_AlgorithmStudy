package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9659 )
 */
public class BJ_09659_돌게임5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		if (N % 2 == 0) {
			System.out.print("CY");
		} else {
			System.out.print("SK");
		}
	}

}
