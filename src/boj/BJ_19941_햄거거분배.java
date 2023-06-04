package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/19941 )
 */
public class BJ_19941_햄거거분배 {

	static int answer, N, K;
	static char[] info;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		info = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (info[i] == 'P') {
				int index = Math.max(i - K, 0);
				boolean check = false;
				for (int j = index; j < i; j++) {
					if (check(j)) {
						check = true;
						break;
					}
				}
				if (!check) {
					index = i + K >= N ? N - 1 : i + K;
					for (int j = i + 1; j <= index; j++) {
						if (check(j))
							break;
					}
				}
			}
		}
		System.out.println(answer);
	}

	static boolean check(int index) {
		if (info[index] == 'H') {
			info[index] = 'X';
			answer++;
			return true;
		}
		return false;
	}
}
