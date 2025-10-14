import java.util.*;
class Solution {

	public static boolean[] visit;

	public int solution(int n, int[][] computers) { // n : 컴퓨터 개수, computers : 컴퓨터 연결 정보

		int answer = 0;

		// java에선 boolean array의 경우 false로 자동 초기화
		// object array의 경우 null로 자동 초기화
		// 0 or -1로 초기화 해줘도 되지만 for문 돌리기 귀찮아서 boolean으로 함
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) { // 모두 true가 되면 끝
				answer++;
				dfs(i, computers, n); // 노드를 0번 노드부터 차례로 방문
			}
		}

		return answer;
	}

	void dfs(int start, int[][] computers, int n) {

		visit[start] = true; // 시작점을 방문 했다고 true로 바꿈

		for (int i = 0; i < n; i++) {
			if (start == i) { // 자기자신과 연결되어있는건 셀 필요가 없으므로 => 이거 처리 해주면 조금 빨라졌음
				continue;
			} else { // 다른 노드와 연결되어 있다면
				if (!visit[i] && (computers[start][i] == 1)) { // 방문하지 않았고, 다른 노드와 연결되어 있다면
					dfs(i, computers, n); // dfs 탐색 ㄱㄱ
				}
			}
		}
	}
}