import java.util.*;
class Solution {
	public int solution(int[] scoville, int K) {

		// list 하고 sort 하니까 시간초과 떠서 우선순위 큐 사용
		int answer = 0;

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			queue.offer(scoville[i]);
		}

		while (queue.peek() <= K) {
            
			if (queue.size() == 1) {  // queue에 한개만 남아서 더이상 못하면
				return -1;
			}
			
            int a = queue.poll();
			int b = queue.poll();

			queue.offer(a + (b * 2));

			answer++;
		}

		return answer;
	}
}