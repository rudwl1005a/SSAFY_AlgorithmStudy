package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/8958 )
 */
public class BJ_08958_OX퀴즈 {

	static int T, ans;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = st.nextToken().toCharArray();
			ans = 0;
			int cnt = 1;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 'O') {
					ans += cnt;
					cnt++;
				} else if(arr[i] == 'X') {
					cnt = 1;
				}
			}
			System.out.println(ans);
		}
	}

}
