package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/9375 )
 */
public class BJ_09374_패션왕신해빈 {

	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Map<String, Integer> map = new HashMap<>();
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 옷 이름은 필요 없음

				String cloth = st.nextToken();
				if (map.containsKey(cloth)) {
					map.put(cloth, map.get(cloth) + 1);
				} else {
					map.put(cloth, 1);
				}
			}

			int result = 1;
			for (int val : map.values()) {
				result *= (val + 1);
			}
			sb.append(result - 1).append('\n');

		}

		System.out.println(sb);
	}
}
