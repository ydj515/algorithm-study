import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int score[] = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % 5])
				score[0]++;
			if (answers[i] == student2[i % 8])
				score[1]++;
			if (answers[i] == student3[i % 10])
				score[2]++;
		}
		int max = Math.max(score[0], Math.max(score[1], score[2]));
		int cnt = 0;
		for (int i = 0; i < score.length; i++) {
			if (max == score[i])
				cnt++;
		}
		int[] answer = new int[cnt];
		for (int i = 0; i < answer.length; i++) {
			if (max == score[i])
				answer[i] = i + 1;
		}
		System.out.println("length : " + answer.length);
		return answer;
    }
}