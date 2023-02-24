package ssafy.study_40th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1744 )
 */
public class BJ_01744_수묶기 {

	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> plus = new PriorityQueue<Integer>((n1, n2) -> n2 - n1); // 내림차순으로 정렬
		PriorityQueue<Integer> minus = new PriorityQueue<Integer>(); // 오름차순으로 정렬
		PriorityQueue<Integer> one = new PriorityQueue<Integer>();
		boolean zero = false;

		N = Integer.parseInt(br.readLine());
		// 1보다 큰 양수, 1, 음수, 0으로 나누어서 각각 저장
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 1) {
				plus.add(n);
			} else if (n == 1) {
				one.add(n);
			} else if (n < 0) {
				minus.add(n);
			} else {
				zero = true;
			}
		}

		// 1보다 큰 양수가 짝수개 있을때와 홀수개 있을때로 나눠서 더한다
		if (plus.size() % 2 == 0) {
			while (!plus.isEmpty()) {
				int n1 = plus.poll();
				int n2 = plus.poll();
				ans += n1 * n2;
			}
		} else {
			int size = plus.size() - 1;
			for (int i = 0; i < size; i += 2) {
				int n1 = plus.poll();
				int n2 = plus.poll();
				ans += n1 * n2;
			}
			ans += plus.poll();
		}

		// 음수가 짝수개 있을때와 홀수개 있을때로 나눠서 더함
		if (minus.size() % 2 == 0) {
			while (!minus.isEmpty()) {
				int n1 = minus.poll();
				int n2 = minus.poll();
				ans += n1 * n2;
			}
		} else {
			int size = minus.size() - 1;
			for (int i = 0; i < size; i += 2) {
				int n1 = minus.poll();
				int n2 = minus.poll();
				ans += n1 * n2;
			}
			if (!zero) { // 0이 있으면 남은 음수는 0과 곱해서 더하면 더 큰수가 되므로 0이 없을때만 남은 음수 더한다
				ans += minus.poll();
			}
		}

		// 1은 곱하는것보다 더하는게 더 크므로 1의 개수만큼 더한다
		ans += one.size();

		System.out.println(ans);

	}

}
