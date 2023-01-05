package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/12904 )
 */
public class BJ_12904_A와B {

	static String origin, target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		origin = br.readLine();
		target = br.readLine();

		while (origin.length() < target.length()) {
			if (target.charAt(target.length() - 1) == 'A') {
				target = target.substring(0, target.length() - 1);
			} else {
				target = target.substring(0, target.length() - 1);
				StringBuilder sb = new StringBuilder(target);
				target = sb.reverse().toString();
			}
		}

		System.out.println(origin.equals(target) ? 1 : 0);
	}

}
