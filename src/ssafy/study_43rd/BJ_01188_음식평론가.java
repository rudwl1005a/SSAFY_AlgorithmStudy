package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1188 )
 */
public class BJ_01188_음식평론가 {

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 소시지의 수
		M = Integer.parseInt(st.nextToken()); // 평론가의 수

		// 소세지를 하나로 이어 붙였을때, M명이 나눠 먹으려면 M-1번의 칼질이 필요하지만
		// 잘라야 하는 곳이 각기 다른 소세시 사이의 틈이었다면 자르지 않아도 된다 -> 유클리드 호제법을 통해서 최대 공약수를 찾고 (최대공약수-1)만큼 틈과 겹치므로 빼주면 된다
		// 그러므로 최소한 M-gcd(N, M)만큼의 칼질이 필요하다
		System.out.println(M - gcd(N, M));
	}

	// 유클리드 호제법
	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

}
