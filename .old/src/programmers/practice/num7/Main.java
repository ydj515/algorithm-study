class Solution {
	boolean solution(String s) {

		boolean answer = true;

		s = s.toLowerCase();

		int cntp = 0;
		int cnty = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p') {
				cntp++;
			}
			if (s.charAt(i) == 'y') {
				cnty++;
			}
		}

		if (cntp != cnty) {
			answer = false;
		}

		return answer;
	}
}