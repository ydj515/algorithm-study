import java.util.*;
class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {

            int cnt = 0;
            int temp = progresses[i];

            while (true) {
                if (temp >= 100) {
                    break;
                }
                temp += speeds[i];
                cnt++;
            }
            list.add(cnt);
            // System.out.println(cnt);
        }

        List<Integer> answerList = new ArrayList<>();
        int index = 0;

        for (int i = index; i < list.size(); i++) {
            int cnt = 1;
            index = i;

            // System.out.println("시작 index : " + index);
            // System.out.println("시작 i : " + i);

            for (int j = index + 1; j < list.size(); j++) {
                
                // System.out.println("list i : " + list.get(i) + ", list j : " + list.get(j));
                
                if (list.get(i) >= list.get(j)) {
                    cnt++;
                    index++;

                } else {
                    i = index;
                    break;
                }
            }
            answerList.add(cnt);
            if (index == list.size() - 1) {
                break;
            }


        }

        // System.out.println(answerList);

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}