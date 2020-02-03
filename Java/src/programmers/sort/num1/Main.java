import java.util.*;

class Solution {
	// Arrays.copyOfRange 사용.
	// 얕은 복사
	// 깊은 복사는 System.arraycopy, Arrays.copyOf와 
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]); // 얕은 복
			
			Arrays.sort(temp);
			
			answer[i] = temp[commands[i][2] - 1];
		}

		return answer;
	}
}