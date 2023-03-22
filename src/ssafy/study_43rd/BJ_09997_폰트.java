package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/9997 )
 */
public class BJ_09997_폰트 {

	static int N, have[], ans;
	static String input[];
	static final int ALLHAVE = 67108863; // 2^26 - 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new String[N];
		have = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
			for (int j = 0; j < input[i].length(); j++) {
				int now = (int) (input[i].charAt(j) - 'a');
				have[i] |= 1 << now; // 사용한 알파벳 종류 저장
			}
		}

		solve(0, 0);

		System.out.println(ans);
	}

	private static void solve(int idx, int cnt) {
		if (idx == N) {
			if (cnt == ALLHAVE) { // 모든 단어를 사용하고 있으면 ans증가
				ans++;
			}
			return;
		}

		solve(idx + 1, cnt | have[idx]); // idx번째 단어를 사용한다
		solve(idx + 1, cnt); // idx번째 단어를 사용하지 않는다
	}

}
