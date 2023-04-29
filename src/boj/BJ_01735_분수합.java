package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1735 )
 */
public class BJ_01735_분수합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int up = a * d + b * c;
		int down = b * d;
		int gcd = getGcd(up, down); // 최대 공약수
		System.out.println(up / gcd + " " + down / gcd);
	}

	private static int getGcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return getGcd(b, a % b);
	}
}
