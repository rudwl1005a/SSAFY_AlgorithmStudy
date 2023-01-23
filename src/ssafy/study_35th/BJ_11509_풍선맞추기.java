package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/11509 )
 */
public class BJ_11509_풍선맞추기 {

	static int N, arr[], arrow;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[1000002];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			if (arr[h + 1] == 0) { // 높이+1인 풍선이 존재하지 않을 경우
				arr[h]++; // 현재 높이의 풍선 개수 증가
				arrow++; // 화살 증가
			} else { // 존재할 경우
				arr[h + 1]--; // 높이+1인 풍선 개수 감소
				arr[h]++; // 현재 높이의 풍선 개수 증가
			}
		}

		System.out.println(arrow);
	}

}
