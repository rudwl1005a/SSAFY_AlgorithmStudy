package ssafy.study_31st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/5430 )
 */
public class BJ_05430_AC {

	static int T, P, N;
	static boolean front; // 뒤집는 함수를 처리하기 위해 앞을 보는지 확인하는 변수
	static boolean err; // 에러가 났는지 확인하는 변수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력 처리
			String func = br.readLine();
			N = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			String[] nums = temp.substring(1, temp.length() - 1).split(",");

			Deque<Integer> deque = new ArrayDeque<>();
			if (N != 0) {
				for (int i = 0; i < nums.length; i++) {
					deque.add(Integer.parseInt(nums[i]));
				}
			}

			// 함수 처리
			front = true;
			err = false;
			for (int i = 0; i < func.length(); i++) {
				char cur = func.charAt(i);
				if (cur == 'R') { // 회전
					front = !front;
				} else if (cur == 'D') { // 첫번째 수 버리기
					if (deque.size() == 0) { // 배열에 수가 없으면 에러
						err = true;
						break;
					}
					if (front) {
						deque.removeFirst();
					} else {
						deque.removeLast();
					}
				}
			}

			// 에러일 경우 처리
			if (err) {
				sb.append("error\n");
				continue;
			}

			// 남은 수가 없을때 처리
			if (deque.size() == 0) {
				sb.append("[]\n");
				continue;
			}

			// 일반적인 경우 처리
			sb.append("[");
			if (front) {
				Iterator it = deque.iterator();
				while (it.hasNext()) {
					sb.append(it.next()).append(",");
				}
				sb.setLength(sb.length() - 1);
			} else {
				Iterator it = deque.descendingIterator();
				while (it.hasNext()) {
					sb.append(it.next()).append(",");
				}
				sb.setLength(sb.length() - 1);
			}
			sb.append("]\n");
		}

		System.out.println(sb);
	}

}
