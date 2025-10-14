package num16402;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	static int root[];

	/* find(x): 재귀 이용 */
	static int find(int x) {

		if (root[x] == x) {// 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
			return x;
		} else {// 각 노드의 부모 노드를 찾아 올라간다.
			return find(root[x]);
		}
	}

	/* union(x, y) */
	static void union(int x, int y) {
		// 각 원소가 속한 트리의 루트 노드를 찾는다.
		x = find(x);
		y = find(y);

		root[y] = x;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 왕국의 수
		int m = scanner.nextInt(); // 전쟁 결과 수

		root = new int[n];
		Vector<String> kingdom = new Vector<String>();
		scanner.nextLine(); // buffer 지우기

		for (int i = 0; i < n; i++) { // 처음 루트는 자기자신
			root[i] = i;
		}

		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			String s[] = input.split(" ");
			kingdom.add(s[2]);
		}

		for (int i = 0; i < m; i++) {
			String input = scanner.nextLine();

			String s[] = input.split(",");

			String s1[] = s[0].split(" ");
			String s2[] = s[1].split(" ");

			if (s[2].equals("1")) {
				for (int j = 0; j < root.length; j++) {
					if (kingdom.get(j).equals(s2[2])) {
						root[j] = kingdom.indexOf(s1[2]);
					}
				}

			} else { // 2라면
				for (int j = 0; j < root.length; j++) {
					if (kingdom.get(j).equals(s1[2])) {
						root[j] = kingdom.indexOf(s2[2]);
					}
				}
			}
		}

		// for (int k = 0; k < root.length; k++) {
		// System.out.print(root[k] + " ");
		// }
		// System.out.println();

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (find(i) == i) {
				cnt++;
			}
		}

		System.out.println(cnt);
		for (int i = 0; i < n; i++) {
			if (find(i) == i) {
				System.out.println("Kingdom of " + kingdom.get(i));
			}
		}

	}

}
