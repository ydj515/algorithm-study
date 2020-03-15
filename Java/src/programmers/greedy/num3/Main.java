import java.util.*;
class Solution {
	public String solution(String number, int k) {
		int idx = 0;
		char max;
		StringBuilder answer = new StringBuilder(); // 처음에 String에다가 max += 해줬는데 시간초과 나서 builder썻음

		// 시작을 0으로 주는 파렴치한 짓을 하네;
		// 예외 처리함
		if (number.charAt(0) == '0') {
			return "0";
		}

		for (int i = 0; i < number.length() - k; i++) {

			max = '0';

			for (int j = idx; j <= k + i; j++) {
				
				System.out.println("number.charat(" + j + ") : " + number.charAt(j) + ", max : " + max);
				
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			answer.append(max);
			System.out.println(answer);
		}
		System.out.println("=================");
		System.out.println(answer.toString());

		return answer.toString();
	}
}