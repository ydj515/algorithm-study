import java.util.*;
class Solution {

	public int solution(int[] citations) {

		int answer = 0;

		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			int h = citations[i];
			int k = citations.length - i;
			if (k <= h) { // h <= 나머지 논문 갯수. h가 밎 논문 갯수보다 인용
				return k;
			}
		}

		return answer;
	}

}