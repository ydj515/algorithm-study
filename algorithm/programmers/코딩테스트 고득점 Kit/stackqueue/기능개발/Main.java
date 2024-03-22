import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new LinkedList<>();
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remainProgress = 100 - progresses[i];
            double fNeedDay = remainProgress / speeds[i];

            int date = (int) Math.ceil(fNeedDay);

            if (!days.isEmpty() && days.peek() < date) {
                answers.add(days.size());
                days.clear();
            }

            days.offer(date);
        }

        answers.add(days.size());

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}