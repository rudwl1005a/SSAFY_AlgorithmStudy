package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G1 ( https://www.acmicpc.net/problem/1019 )
 */
public class BJ_01019_책페이지 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		sb.append(count0(N)).append(" ");
		for (int i = 1; i <= 9; i++) {
			sb.append(count(N, i)).append(" ");
		}
		sb.append("\n");
		System.out.println(sb);

	}
	
	private static long count0(long n) {
		if (n < 0) {
			return 0;
		}

		long result = 0;
		long ten = 1;
		while (n / ten != 0) {
			long next = n / (ten * 10);
			long current = (n % (ten * 10)) / ten;
			long prev = n % ten;

			if (current != 0) {
				result += next * ten;
			} else {
				result += (next - 1) * ten + (prev + 1);
			}

			ten *= 10;
		}
		return result;
	}

	private static long count(long n, int num) {
		if (n < 0) {
			return 0;
		}

		long result = 0;
		long ten = 1;
		while (n / ten != 0) {
			long next = n / (ten * 10);
			long current = (n % (ten * 10)) / ten;
			long prev = n % ten;

			if (current > num) {
				result += (next + 1) * ten;
			} else if (current == num) {
				result += next * ten + (prev + 1);
			} else {
				result += next * ten;
			}
			ten *= 10;
		}
		return result;
	}

}
