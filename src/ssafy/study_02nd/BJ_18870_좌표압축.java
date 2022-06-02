package ssafy.study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 백준 실버2 ( https://www.acmicpc.net/problem/18870 )
 */
public class BJ_18870_좌표압축 {

	static int N, cnt;
	static int[] num, temp;
	static Map<Integer, Integer> map = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		temp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			num[i] = tmp;
			temp[i] = tmp;
		}
		
		Arrays.sort(temp);
		
		for(int i=0; i<N; i++) {
			if(map.containsKey(temp[i])) continue;
			map.put(temp[i], cnt++);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(num[i])).append(" ");
		}
		System.out.println(sb);
		
	}
	
}


	// 시간초과
//	static int N;
//	static ArrayList<Integer> input = new ArrayList<>();
//	static ArrayList<Integer> sortedInput = new ArrayList<>();
//	static StringBuilder sb = new StringBuilder();
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			input.add(tmp);
//			if(sortedInput.contains(tmp)) continue;
//			sortedInput.add(tmp);
//		}
//		
//		Collections.sort(sortedInput, (it1, it2) -> it1 - it2);
//		for(int i=0; i<N; i++) {
//			sb.append(sortedInput.indexOf(input.get(i))).append(" ");
//		}
//		
//		System.out.println(sb);
//	}
