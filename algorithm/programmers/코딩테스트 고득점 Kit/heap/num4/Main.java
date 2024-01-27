import java.util.*;
class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < operations.length; i++) {
			String[] oneOperationArray = operations[i].split(" ");

			if (oneOperationArray[0].equals("I")) { // 큐에 삽입 연산
				list.add(Integer.parseInt(oneOperationArray[1]));
				Collections.sort(list); // 오름차순 정렬
			}
			if (oneOperationArray[0].equals("D")) { // 큐에서 삭제 연산
				if (oneOperationArray[1].equals("1")) { // 최댓값 삭제
					if (list.size() != 0) { // list가 있어야 비우니까
						list.remove(list.size() - 1);
					}

				} else if (oneOperationArray[1].equals("-1")) { // 최솟값 삭제
					if (list.size() != 0) { // list가 있어야 비우니까
						list.remove(0);
					}

				}
			}
		}

		// System.out.println(list);
		if (list.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = list.get(list.size() - 1);// 최댓값
			answer[1] = list.get(0); // 최솟값
		}

		// for (int i = 0; i < answer.length; i++) {
		// System.out.println(answer[i]);
		// }

		return answer;
	}
}