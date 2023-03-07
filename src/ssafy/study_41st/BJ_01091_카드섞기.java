package ssafy.study_41st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1091 )
 */
public class BJ_01091_카드섞기 {

	static int N, p[], s[], card[], copy[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 카드 초기상태 저장
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = i % 3;
		}

		p = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		s = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}

		copy = card.clone(); // 깊은복사
		while (true) {
			boolean flag = true;
			for (int i = 0; i < N; i++) { // card가 p와 같은지 확인
				if (card[i] != p[i]) {
					flag = false;
					break;
				}
			}
			if (!flag) { // card와 p가 다를 경우 한번 더 섞어서 복사
				for (int i = 0; i < N; i++) {
					copy[i] = card[s[i]];
				}
				card = copy.clone();
				ans++;
			} else { // card가 p와 같다면 ans 출력
				System.out.println(ans);
				return;
			}

			// 계속 반복되어서 초기상태와 같아진다면 -1 출력
			flag = true;
			for (int i = 0; i < N; i++) {
				if (card[i] != i % 3) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println(-1);
				return;
			}

		}
	}

}
