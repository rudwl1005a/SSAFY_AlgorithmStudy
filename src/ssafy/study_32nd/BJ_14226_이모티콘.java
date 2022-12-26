package ssafy.study_32nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/14226 )
 */
public class BJ_14226_이모티콘 {

	static int S;
	// 화면 + 클립보드 체크되야해서 배열크기 2002
	static boolean[][] visited = new boolean[2002][2002];
	static Queue<Node> q = new LinkedList<>();
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());

		visited[1][0] = true;
		q.add(new Node(1, 0, 0));

		// 길이가 같아지면 종료
		// 클립에 복사, 붙여넣기, 삭제
		while (!q.isEmpty()) {

			Node node = q.poll();

			if (node.len == S) {
				min = node.cnt;
				break;
			}
			// 클립에 복사
			q.add(new Node(node.len, node.len, node.cnt + 1));

			// 붙여넣기
			if (node.clip != 0 && !visited[node.len + node.clip][node.clip] && node.len + node.clip <= 1000) {
				visited[node.len + node.clip][node.clip] = true;
				q.add(new Node(node.len + node.clip, node.clip, node.cnt + 1));
			}

			// 삭제
			if (node.len > 0 && !visited[node.len - 1][node.clip] && node.len - 1 <= 1000) {
				visited[node.len - 1][node.clip] = true;
				q.add(new Node(node.len - 1, node.clip, node.cnt + 1));
			}
		}

		System.out.println(min);
	}

	static class Node {
		int len;
		int clip;
		int cnt;

		Node(int len, int clip, int cnt) {
			this.len = len;
			this.clip = clip;
			this.cnt = cnt;
		}
	}

}
