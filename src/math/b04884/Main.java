package math.b04884;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
//		long curLong = System.currentTimeMillis(); 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			long g = Long.parseLong(token.nextToken());
			long t = Long.parseLong(token.nextToken());
			long a = Long.parseLong(token.nextToken());
			long d = Long.parseLong(token.nextToken());
			if(g == -1) break;
			
			long allGame; // 전체 게임 수
			long gGame = (t * (t-1) / 2) * g; // 조별 게임 수

			long passTeam = g*a + d; // 조별 리그 통과한 팀
			long addTeam; // 토너먼트 추가해야하는 팀 수
			// 토너먼트 추가해야 하는 팀 수 계산
			long num = 1;
			while(true) {
				if((g*a + d) <= num) {
					addTeam = num - passTeam;
					break;
				}
				num *= 2;
			}
			
			long tournamentTeam = g*a + addTeam + d; // 토너먼트 올라가는 팀 수
			long tGame = tournamentTeam - 1; // 토너먼트 경기 수
			allGame = gGame + tGame;
			System.out.println(g+"*"+a+"/"+t+"+"+d+"="+allGame+"+"+addTeam);
			
//			StringBuilder sb = new StringBuilder();
//			sb.append(g);
//			sb.append("*");
//			sb.append(a);
//			sb.append("/");
//			sb.append(t);
//			sb.append("+");
//			sb.append(d);
//			sb.append("=");
//			sb.append(allGame);
//			sb.append("+");
//			sb.append(addTeam);
//			System.out.println(sb.toString());
//			long endLong = System.currentTimeMillis();
//			System.out.println(endLong - curLong);

		}
	}
}
