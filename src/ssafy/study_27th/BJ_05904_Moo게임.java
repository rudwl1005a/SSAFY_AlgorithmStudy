package ssafy.study_27th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/5904 )
 */
public class BJ_05904_Moo게임 {

	static int N, old, now, mid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		now = 3;
		mid = 3;

		// 최초로 N보다 큰 문자열 찾기
		while (N > now) {
			old = now;
			now = now * 2 + (mid + 1);
			mid++;
		}

		// 이분탐색
		// moo수열은 S(n-1)+(mo...o)+S(n-1) 세 단계로 나눌 수 있다.
		while (true) {
			if (old < N && N <= old + mid) { // N이 중간에 있을때
				N -= old;
				break;
			}
			if (N <= old) { // N이 첫번째 단계에 있을 때
				now = old;
				mid--;
				old = (now - mid) / 2;
			} else { // N이 세번째 단계에 있을 때
				now = old;
				N -= old + mid;
				mid--;
				old = (now - mid) / 2;
			}
		}

		// N이 중간에 있을 때 moooooooo...oo이므로 첫번째 빼고는 모두 o를 출력한다
		if (N == 1) System.out.println('m');
		else System.out.println('o');

	}

}
