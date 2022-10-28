package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 정보올림피아드 ( http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=3977&sca=99&page=32 )
 */
public class JO_04618_트리나누기 {

	static boolean isEnd, visit[];
    static int n, num, tgt[], copyEdges[][], map[][];
    static PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		int[][] edges = new int[n-1][2];
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[2];

        num = n/3;
        tgt = new int[2];
        copyEdges = edges;

        map = new int[n][n];
        for(int i = 0; i < n - 1; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }

        solve(0, 0);

        answer[0] = pq.poll();
        answer[1] = pq.poll();
        
        System.out.println(answer[0] + " " + answer[1]);
        
    }

    public static void solve(int tgtIdx, int srcIdx) {
        if(isEnd) return; // 이미 정답이 나온 경우 가지치기
        if(tgtIdx == 2) {
            int[] nodenums = new int[4];
            nodenums[0] = copyEdges[tgt[0]][0]; // 첫번째 간선의 첫번째 노드번호
            nodenums[1] = copyEdges[tgt[0]][1]; // 첫번째 간선의 두번째 노드번호
            nodenums[2] = copyEdges[tgt[1]][0]; // 두번째 간선의 첫번째 노드번호
            nodenums[3] = copyEdges[tgt[1]][1]; // 두번째 간선의 두번째 노드번호

            // 노드 끊어진 트리 생성
            map[nodenums[0]][nodenums[1]] = 0;
            map[nodenums[1]][nodenums[0]] = 0;
            map[nodenums[2]][nodenums[3]] = 0;
            map[nodenums[3]][nodenums[2]] = 0;

            boolean flag = true;
            // 남은 노드들의 크기가 num인지 확인 후 정답이면 pq에 넣기
            for(int i = 0; i < 4; i++){
                visit = new boolean[num*3];
                if(check(nodenums[i]) != num){
                    flag = false;;
                }
            }

            if(flag) { // 전부 num이면 tgt pq에 넣기
                pq.offer(tgt[0]);
                pq.offer(tgt[1]);
                isEnd = true;
            }

            // 트리 복구
            map[nodenums[0]][nodenums[1]] = 1;
            map[nodenums[1]][nodenums[0]] = 1;
            map[nodenums[2]][nodenums[3]] = 1;
            map[nodenums[3]][nodenums[2]] = 1;

            return;
        }
        if(srcIdx > (num*3)-2) {
            return;
        }

        tgt[tgtIdx] = srcIdx;
        solve(tgtIdx + 1, srcIdx + 1);
        solve(tgtIdx, srcIdx + 1);
    }

    public static int check(int n) {
        int result = 1;

        visit[n] = true;

        for(int i = 0; i < num*3; i++) {
            if(visit[i] || map[n][i] == 0) continue;
            result += check(i);
        }

        return result;
	}

}
