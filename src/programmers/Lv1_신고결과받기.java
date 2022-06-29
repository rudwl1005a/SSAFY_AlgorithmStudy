package programmers;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 프로그래머스 ( https://programmers.co.kr/learn/courses/30/lessons/92334 )
 */
public class Lv1_신고결과받기 {

	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		int[] result = s.solution(id_list, report, k);
		System.out.println(Arrays.toString(result));
	}
	
	static class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int n = id_list.length;
	        
	        int[] answer = new int[n];
	        
	        HashMap<String, Integer> users = new HashMap<>();
	        for (int i = 0; i < n; i++) {
				users.put(id_list[i], i);
			}
	        
	        boolean[][] report_list = new boolean[n][n];
	        int[] result = new int[n];
	        
	        int m = report.length;
	        for (int i = 0; i < m; i++) {
				String user = report[i].split(" ")[0];
				String rep_user = report[i].split(" ")[1];
				
				report_list[users.get(user)][users.get(rep_user)] = true;
			}
	        
	        for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(report_list[i][j]) result[j]++;
				}
			}
	        
	        for (int i = 0; i < n; i++) {
				if(result[i] >= k) {
					for (int j = 0; j < n; j++) {
						if(report_list[j][i]) answer[j]++;
					}
				}
			}
	        
	        return answer;
	    }
	}

}
