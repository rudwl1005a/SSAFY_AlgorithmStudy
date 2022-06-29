package programmers;

/*
 * 프로그래머스 ( https://programmers.co.kr/learn/courses/30/lessons/92335 )
 */
public class Lv2_k진수에서소수개수구하기 {

	public static void main(String[] args) throws Exception {
		
		Solution s = new Solution();
		int n = 110011;
		int k = 10;
		System.out.println(s.solution(n, k));
		
	}

	static class Solution {
	    public int solution(int n, int k) {
	        int answer = 0;

	        String[] num = Long.toString(n, k).split("0");

	        for (String s : num) {
	            // 소수 판별
	            if (s.equals("")) continue;
	            if (isPrime(Long.parseLong(s))) answer++;
	        }

	        return answer;
	    }

	    private boolean isPrime(long n) {
	        if(n == 1) return false;

	        // 에라토스테네스의 체
	        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
	            if(n % i == 0) return false;
	        }
	        return true;
	    }
	}
}
