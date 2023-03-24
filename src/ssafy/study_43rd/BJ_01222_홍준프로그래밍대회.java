package ssafy.study_43rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/1222 )
 */
public class BJ_01222_홍준프로그래밍대회 {

	static int N, student[], max;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		// 학생 수가 N인 학교의 수 저장
		student = new int[2000001];

		// 최대인 학생 수
		max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			student[a]++;
		}

		for (int i = 1; i <= max; i++) {
			int cnt = 0; // 팀원수 i로 했을 때 본선 진출 팀

			// i배수인 학생수를 갖는 학교는 본선 참가 가능
			for (int j = i; j <= max; j += i) {
				cnt += student[j];
			}

			if (cnt < 2) continue; // 본선 진출팀 2팀 이하면 x

			ans = Math.max(ans, (long) cnt * (long) i);
		}

		System.out.println(ans);
	}

}
