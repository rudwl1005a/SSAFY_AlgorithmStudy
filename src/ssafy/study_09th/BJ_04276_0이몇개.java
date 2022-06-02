package ssafy.study_09th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/4276 )
 */
public class BJ_04276_0이몇개 {

	static long to, from;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			to = Long.parseLong(st.nextToken());
			from = Long.parseLong(st.nextToken());
			if (to == -1 && from == -1) {
				break;
			}

			System.out.println(Math.abs(count0(to - 1) - count0(from)));
		}
	}

	private static long count0(long n) {
		if (n < 0) { // 0부터 시작하는 예외를 위해서
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
		return result + 1;
	}

}
