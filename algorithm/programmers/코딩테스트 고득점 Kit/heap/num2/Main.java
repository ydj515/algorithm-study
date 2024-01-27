import java.util.*;
class Solution {
	public int solution(int stock, int[] dates, int[] supplies, int k) {

		// 아니 list쓰고 reverser order 정렬 하니까 시간초과 나서 prior queue 사용했다.
		// stock : 현재 밀가루 수량
		// dates : 밀가루 공급 일정. 오름차순 정렬을 해준 상태로 주어짐
		// supplies : 해당 시점에 공급 가능한 밀가루 수량
		// k : 원래 공장으로로부터 공급 받을 수 있는 시점

		int answer = 0;
		int index = 0;
		int index2 = 0;

		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		while (stock < k) { // 현재 밀가루 재고가 공급 받을 수 있는 시점보다 작을 때 까지 돈다.
			for (int i = index; i < dates.length; i++) {
				if (dates[i] <= stock) {
					queue.offer(supplies[i]);
					index2 = i;
				}
			}
			// 밀가루 공급 받는다.
			index = index2 + 1;
			stock += queue.poll();
			answer++;
		}

		return answer;
	}
}