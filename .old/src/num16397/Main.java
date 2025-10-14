package num16397;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int t = scanner.nextInt();
		int g = scanner.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> w = new LinkedList<>();
		
		// 큐 2개를 사용하였다. class로 해도 괜찮을 것 같다.
//		Queue<Pair> qq = new LinkedList<>();
		
		q.add(n);
		w.add(0);
//		Pair p = new Pair(n, 0);
//		qq.add(p);
		
		boolean[] visited = new boolean[100001];
		int ans = -1;

		while (!q.isEmpty()) {
			
			int nn = q.poll();
			int ww = w.poll();
			
//			int cur = qq.poll().x;
//			int cnt = qq.poll().y;
			
			
			if (nn == g) {
				System.out.println(ww);
				return;
			}

			if (visited[nn] || nn >= 99999 || ww >= t)
				continue;

			visited[nn] = true;

			q.add(nn + 1);
			w.add(ww + 1);

			if (nn * 2 <= 99999) {
				String s = Integer.toString(nn * 2);
				char[] cc = s.toCharArray();

				if (cc[0] == '1' || cc[0] == '0') {
					cc[0] = '0';
				} else {
					cc[0]--;
				}

				nn = Integer.parseInt(new String(cc));

				q.add(nn);
				w.add(ww + 1);
			}
		}

		System.out.println("ANG");

	}

//	class Pair {
//		
//		int x;
//		int y;
//
//		public Pair(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//
//	}

}
