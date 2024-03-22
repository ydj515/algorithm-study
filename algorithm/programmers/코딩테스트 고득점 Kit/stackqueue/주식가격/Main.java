import java.util.*;
class Solution {
    public int[] solution(int[] prices) {

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {

            int cnt = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            answers.add(cnt);
        }

        answers.add(0); // 마지막은 무조건 0

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}