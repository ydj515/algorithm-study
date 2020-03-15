import java.util.*;
class Solution {
	public int[] solution(int[] arr, int divisor) {

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] % divisor) == 0) {
				al.add(arr[i]);
			}
		}

		if (al.size() == 0) {
			al.add(-1);
		}
		Collections.sort(al);
		int[] answer = new int[al.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}
}