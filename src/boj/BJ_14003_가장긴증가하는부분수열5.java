package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 P5 ( https://www.acmicpc.net/problem/14003 )
 */
public class BJ_14003_가장긴증가하는부분수열5 {

	static int N, arr[], indexs[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		indexs = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 이분탐색으로 LIS 구하기
		for (int i = 0; i < N; i++) {
			if (list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
				indexs[i] = list.size() - 1;
			} else {
				int left = 1;
				int right = list.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (list.get(mid) < arr[i]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				list.set(right, arr[i]);
				// 리스트에 자신의 위치 기록
				indexs[i] = right;
			}
		}
		sb.append(list.size() - 1).append("\n");

		int index = list.size() - 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			// 찾길 원하는 인덱스와 같으면
			if (indexs[i] == index) {
				index--; // 인덱스 감소
				stack.push(arr[i]); // 경로 추가
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
