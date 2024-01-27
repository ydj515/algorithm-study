import java.util.*;

class Solution {

	public static int answer = 0;

	public int solution(int[] numbers, int target) {
		// 모든 경우의 수 찾는것 => DFS
		// recursive or stack
		// 나는 재귀 ㅋㅅㅋ

		dfs(target, numbers, 0);

		return answer;
	}

	// recursive 이용
	public static void dfs(int target, int[] numbers, int k) {

		if (k == numbers.length) {
			// System.out.println("<if> k :" + k + ", numbers.length : " + numbers.length);
			// System.out.println("===================================");

			int sum = 0;

			for (int i = 0; i < numbers.length; i++) {
				// System.out.println("numbers[" + i + "] : " + numbers[i]);
				sum += numbers[i];
			}

			// System.out.println("sum : " + sum);

			if (sum == target) {
				answer++;
			}

			return;

		} else {
			// System.out.println("<else> k :" + k + ", numbers.length : " + numbers.length);
			// System.out.println("===================================");

			numbers[k] *= 1;
			dfs(target, numbers, k + 1); // + 노드
			// System.out.println("===================================왼쪽 (+) 노드 끝 ㅋ");

			numbers[k] *= -1;
			dfs(target, numbers, k + 1); // - 노드
			// System.out.println("===================================왼쪽 (-) 노드 끝 ㅋ");
		}
	}

}