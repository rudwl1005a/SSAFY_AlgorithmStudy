package ssafy.study_22nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/16472 )
 */
public class BJ_16472_고냥이 {

	static int N, M, left, right, ans;
	static int[] used = new int[26];
	static char[] str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 문자열 최대 개수

		str = br.readLine().toCharArray();
		M = str.length; // 문자열의 길이

		int cnt = 0; // 현재 인식한 문자 개수
		while (right < M) {
			int curIdx = (int) (str[right] - 'a');
			if (cnt < N) { // 인식 가능한 문자 추가 가능하면
				if (used[curIdx] == 0) { // 새롭게 추가된 인식가능 문자면
					cnt++;
				}
				used[curIdx]++;
				right++;
			} else { // 추가 불가능하면
				if (used[curIdx] > 0) { // 인식 가능 문자면
					used[curIdx]++;
					right++;
				} else { // 인식 불가능 문자면
					used[(int) (str[left] - 'a')]--;
					if (used[(int) (str[left] - 'a')] == 0) {
						cnt--;
					}
					left++;
				}
			}
			ans = Math.max(ans, right - left);
		}

		System.out.println(ans);
	}

}
