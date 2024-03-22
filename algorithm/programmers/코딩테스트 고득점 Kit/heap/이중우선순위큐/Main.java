import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        // linkedList는 중간에 요소 접근 시 유리. ArrayDeque 큐의 앞뒤, 정렬이 필요하면 priorityqueue
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());


        for (String operation : operations) {
            String[] arr = operation.split(" ");

            if (arr[0].equals("I")) { // 삽입
                minQueue.offer(Integer.valueOf(arr[1]));
                maxQueue.offer(Integer.valueOf(arr[1]));
            } else { // 삭제
                if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                    if (Integer.parseInt(arr[1]) == 1) {
                        Integer max = maxQueue.poll();
                        minQueue.remove(max);
                    } else { // -1이라면
                        Integer min = minQueue.poll();
                        maxQueue.remove(min);
                    }
                }
            }

        }

        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek();

        return answer;
    }
}