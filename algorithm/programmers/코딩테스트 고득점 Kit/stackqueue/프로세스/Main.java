import java.util.*;
class Solution {
	public int solution(int[] priorities, int location) {

		Queue<Printer> queue = new LinkedList();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(new Printer(priorities[i], i));
		}

		// 정렬(오름차순)
		Arrays.sort(priorities);
		for (int i = 0; i < priorities.length; i++) {
			System.out.println("pro 배열 [" + i + "] : " + priorities[i]);
		}

		int pointer = priorities.length - 1;
		int cnt = 1;

		while (!queue.isEmpty()) {
			Printer p = queue.poll(); // 일단 꺼내서

			if (p.priority == priorities[pointer]) {
				if (p.index == location) {
					break;
				}

				cnt++;
				pointer--;
			} else {
				queue.add(p);
			}
		}

		System.out.println(cnt);
		return cnt;
	}
}

class Printer {
	int priority;
	int index;

	Printer(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}
}