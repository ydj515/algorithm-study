import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        // 우선순위 큐를 활용하여 넣으면서 sort 한다.
        Queue<Integer> queue = new PriorityQueue<>();

        for (int item : scoville) {
            queue.offer(item);
        }

        while (queue.isEmpty() || queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }

            Integer a = queue.poll();
            Integer b = queue.poll();

            if (a != null && b != null) {
                queue.offer(a + (b * 2));
            }

            answer++;
        }

        return answer;
    }
}