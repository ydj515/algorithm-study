package num16404;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int idx = 1;
	static int left[];
	static int right[];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 사원 수
		int m = scanner.nextInt(); // 명령 수

		ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= n; i++)
			edge.add(new ArrayList<>());

		for (int i = 1; i <= n; i++) {
			int v = scanner.nextInt();

			if (i == 1) // 승범이의 경우
				continue;

			edge.get(v).add(i);
		}

		left = new int[n + 1];
		right = new int[n + 1];
		dfs(1, edge);

		String s = "";

		for (int i = 0; i < m; i++) {
			int command = scanner.nextInt();

			if (command == 1) { // 직원 v 가 w 만큼 이익 or 손해
				int v = scanner.nextInt();
				int w = scanner.nextInt();

				update(1, w, left[v], right[v], 1, n); // node, w, int left, int right, int start, int end
			} else { // 직원 i의 잔액 출력
				int v = scanner.nextInt();

				// 한번에 결과 출력을 위해 문자열에 합쳐야한다.
				s += get(1, right[v], right[v], 1, n) + "\n"; // int node, int left, int right, int start, int end
			}

		}

		System.out.print(s); // 한번에 결과 출력

		scanner.close();
	}

	static void dfs(int index, ArrayList<ArrayList<Integer>> edge) {

		left[index] = idx;
		
		for (int i = 0; i < edge.get(index).size(); i++) {
			dfs(edge.get(index).get(i), edge);
		}
		
		right[index] = idx++;
	}

	static int tree[] = new int[4000000];
	static int lazy[] = new int[4000000];

	static void propagation(int node, int start, int end) {
		tree[node] += lazy[node] * (end - start + 1);
		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}
		lazy[node] = 0;
	}

	static int get(int node, int left, int right, int start, int end) {
		if (lazy[node] != 0)
			propagation(node, start, end);
		if (left > end || right < start)
			return 0;
		if (left <= start && end <= right)
			return tree[node];
		return get(node * 2, left, right, start, (start + end) / 2)
				+ get(node * 2 + 1, left, right, ((start + end) / 2) + 1, end);
	}

	static void update(int node, int w, int left, int right, int start, int end) {
		if (lazy[node] != 0)
			propagation(node, start, end);
		if (left > end || right < start)
			return;
		if (left <= start && end <= right) {
			tree[node] += w * (end - start + 1);
			if (start != end) {
				lazy[node * 2] += w;
				lazy[node * 2 + 1] += w;
			}
			return;
		}

		update(node * 2, w, left, right, start, (start + end) / 2);
		update(node * 2 + 1, w, left, right, ((start + end) / 2) + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

}
