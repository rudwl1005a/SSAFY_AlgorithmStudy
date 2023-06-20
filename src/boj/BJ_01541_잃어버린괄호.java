package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1541 )
 */
public class BJ_01541_잃어버린괄호 {

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 식이 최소가 되기 위해서는 빼기 연산 뒤쪽이 커져야 한다
		String[] input = br.readLine().split("-"); // 빼기 기준으로 분리
		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			String[] input2 = input[i].split("\\+"); // 더하기 기준으로 분리
			for (int j = 0; j < input2.length; j++) {
				sum += Integer.parseInt(input2[j]);
			}
			if (i == 0) {
				ans += sum;
			} else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}

}
