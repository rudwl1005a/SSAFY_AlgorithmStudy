package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * 백준 B5 ( https://www.acmicpc.net/problem/15740 )
 */
public class BJ_15740_ApulsB9 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정수 표현의 범위가 엄청나게 커서 표현할 수 없을 때 BigInteger를 사용한다
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		
		sb.append(n.add(m));
		
		System.out.println(sb);
	}
}
