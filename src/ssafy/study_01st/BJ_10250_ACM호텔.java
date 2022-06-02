package ssafy.study_01st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 B3 ( https://www.acmicpc.net/problem/10250 )
 */
public class BJ_10250_ACM호텔 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer sToken = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(sToken.nextToken());
			int w = Integer.parseInt(sToken.nextToken());
			int n = Integer.parseInt(sToken.nextToken());
			
			int up; int left;
			if(n % h == 0) {
				up = h; left = n / h;
			}
			else{
				up = n % h; left = n / h + 1;
			}
			
			System.out.println(100*up + left);
		}
	}
}
