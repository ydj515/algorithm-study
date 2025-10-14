import java.util.*;
class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		// 터뜨려진 인형의 갯수를 구하는 문제다... size 구하는게 아니다

		// 각 세로 한줄을 스택으로 만듬
		// n x n 정 사각형이다
		List<Stack> stackList = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			stackList.add(new Stack<Integer>());
		}

		// 스택에 다 넣기
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = board.length - 1; j >= 0; j--) {
				if (board[i][j] != 0) {
					stackList.get(j).push(board[i][j]);
				}

			}
		}

		Stack<Integer> answerStack = new Stack<>();
		// System.out.println(stackList);
		for (int i = 0; i < moves.length; i++) {
			// System.out.println(answerStack);
			if (stackList.get(moves[i] - 1).size() > 0) { // 빼려고 하는데 스택이 다 비어서 못빼는 경우 ex) movies의 세번째 1
				Integer tempI = (Integer) stackList.get(moves[i] - 1).pop();

				if (answerStack.size() > 0) { // 정답 스택이 비어있지 않다면 비교해서 push
					Integer answerTempi = answerStack.peek();

					if (answerTempi == tempI) {
						answerStack.pop();
						answer += 2; // 터뜨러진 인형이 두개씩 이니까 +2
						continue;
					} else { // 정답 스택이 비어있다면 무조건 push
						answerStack.push(tempI);
					}
				} else {
					answerStack.push(tempI);
				}
			}

		}
//		System.out.println(answer);
		return answer;
	}
}