package ssafy.study_18th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/10253 )
 */
public class BJ_10253_헨리 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			while (true) {
				int x = henry(a, b);

				if (a * x == b) {
					System.out.println(x);
					break;
				}

				a = a * x - b;
				b = b * x;
			}
		}
	}

	public static int henry(int a, int b) {
		int n = b / a;
		if (n * a >= b) {
			return n;
		}
		return n + 1;
	}
}
