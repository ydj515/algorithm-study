package num15900;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int sum;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		tree = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 1; i < n; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		visited = new boolean[n + 1];
		dfs(1, 0);

		if (sum % 2 == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	static void dfs(int u, int count) {
		visited[u] = true;

		for (int v : tree[u]) // for Each
			if (!visited[v])
				dfs(v, count + 1);

		if (u != 1 && tree[u].size() == 1)
			sum += count;
	}

}
