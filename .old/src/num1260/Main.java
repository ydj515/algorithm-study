package num1260;

import java.util.*;

public class Main {

	static int map[][];
	static boolean[] visit;
	static int n, m, v;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt(); // vertex 수
		m = scanner.nextInt(); // edge 수
		v = scanner.nextInt(); // 탐색 시작 번호

		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int j = 0; j < n + 1; j++) {
			Arrays.fill(map[j], 0); // map 초기화
		}

		Arrays.fill(visit, false); // visit 배열을 false로 전부 초기화

		for (int i = 0; i < m; i++) {

			int a = scanner.nextInt();
			int b = scanner.nextInt();

			map[a][b] = 1;
			map[b][a] = 1;
		}

		dfs(v);

		System.out.println();
		Arrays.fill(visit, false);

		bfs(v);

		scanner.close();
	}

	// recursive 이용
	public static void dfs(int i) {

		visit[i] = true;

		System.out.print(i + " ");

		for (int j = 1; j < n + 1; j++) {
			if (map[i][j] == 1 && visit[j] == false) {
				dfs(j); // 내가 찾은 경로가 만약에 다른 경로가 있으면 바로 다음 곳으로 이동시키고 만약에 없으면, 다시 리커해서 돌아오는 방식임.
			}
		}
	}

	// bfs는 queue 사용
	public static void bfs(int i) {

		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(i); // enqueue
		visit[i] = true; // 방문한 위치는 알아야하니까, 그것을 체크하기 위해서 visit가 필요.

		while (!q.isEmpty()) {
			int temp = q.poll(); // dequeue. 첫번째 방문한 위치는 빼주기로 한다.

			System.out.print(temp + " ");

			for (int k = 1; k <= n; k++) {
				if (map[temp][k] == 1 && visit[k] == false) {
					q.offer(k);
					visit[k] = true; // true라면 방문을 한거임.
				}
			}
		}
	}
}