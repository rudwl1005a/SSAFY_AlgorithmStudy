package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1339 )
 */
public class BJ_01339_단어수학 {

	static int N, ans;
	static Alphabet[] alpha;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		alpha = new Alphabet[26];
		for (int i = 0; i < 26; i++) {
			alpha[i] = new Alphabet(i, 0);
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				int n = (int) (s.charAt(j) - 'A');
				int size = (int) (Math.pow(10, s.length() - j - 1)); // 자릿수
				alpha[n].size += size; // 자릿수의 합 저장
			}
		}

		Arrays.sort(alpha); // 자릿수의 합이 큰 것 대로 저장

		int n = 9;
		for (int i = 0; i < 10; i++) {
			ans += alpha[i].size * n--; // 9에서 1씩 줄여가면서 합하면 정답
		}
		
		System.out.println(ans);

	}

	static class Alphabet implements Comparable<Alphabet> {
		int n, size;

		public Alphabet(int n, int size) {
			super();
			this.n = n;
			this.size = size;
		}

		@Override
		public int compareTo(Alphabet o) {
			// TODO Auto-generated method stub
			return o.size - this.size;
		}

	}

}
