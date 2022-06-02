package ssafy.study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/1436 )
 * 티스토리 풀이 ( https://fbtmdwhd33.tistory.com/20 )
 */
// 메모리: 86,152KB, 실행시간: 316ms -> 코드는 깔끔한데 메모리랑 시간이 늘었음
public class BJ_01436_영화감독숌2 {

	static int N, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int num = 665; // 666이 나오는 첫번째 숫자-1 부터 증가
		while(N>0) {
			num++;
			// String.valueOf(Object) - Object를 String으로 변경
			if(String.valueOf(num).contains("666")) N--; 
		}
		System.out.println(num);
	}
}
