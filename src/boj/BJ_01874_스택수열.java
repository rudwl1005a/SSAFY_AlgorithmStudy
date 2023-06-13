package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1874 )
 */
public class BJ_01874_스택수열 {

	static int N, arr[], cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		cnt = 1;
		Stack<Integer> stack = new Stack<>();
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			stack.push(i);
			ans.add("+");
			while (!stack.empty() && stack.peek() == arr[cnt]) {
				stack.pop();
				ans.add("-");
				cnt++;
			}
		}

		// 출력
		if (stack.empty()) {
			StringBuilder sb = new StringBuilder();
			for (String s : ans) {
				sb.append(s).append("\n");
			}
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}

}
