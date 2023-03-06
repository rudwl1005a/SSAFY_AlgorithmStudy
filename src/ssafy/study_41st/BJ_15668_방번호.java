package ssafy.study_41st;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/15668 )
 */
public class BJ_15668_방번호 {

	static int N;
	static boolean select[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 카드를 최대 5장 까지 사용가능하므로 하나의 숫자는 98765를 넘을 수 없다
		for (int i = 1; i <= 98765 && i < N; i++) {
			int A = i;
			int B = N - i;
			select = new boolean[10];
			// A, B가 조건에 맞는지 확인
			if (check(A) && check(B)) {
				System.out.println(A + " + " + B);
				return;
			}
		}

		// 만족하는 A, B가 존재하지 않는다면
		System.out.println(-1);

	}

	private static boolean check(int num) {
		while (num > 0) {
			if (select[num % 10]) {
				return false;
			}
			select[num % 10] = true;
			num /= 10;
		}
		return true;
	}

}
