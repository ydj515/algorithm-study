class Solution {
	public int solution(String s) {

		int answer = 99999999; // 굉장히 큰 값

		for (int i = 1; i < s.length(); i++) { // 압축 단위가 1부터 해야하므로 1부터 시작
			String compressString = ""; // 압축된 단어
			String unit = ""; // 압축 단위
			String temp = "";

			int cnt = 1;

			// a
			// aa
			// aab
			// aabb
			// aabba ...
			unit = s.substring(0, i); // (시작index포함, len index전꺼까지

			// 단위만큼 잘랐을 때 각 부분의 시작 인덱스
			// unit 지정후 뒤부터 시작하면됨
			for (int j = i; j < s.length(); j += i) {
				temp = "";

				for (int k = j; k < i + j; k++) {
					if (k >= s.length()) {
						break;
					}
					temp = s.substring(j, k + 1);
				}
				// System.out.println("=====");

				if (unit.equals(temp)) { // 압축 앞에 숫자 ++
					cnt++;
				} else { // 더이상 압축 못하면
					if (cnt > 1) { // 압축이 한번 이상 됫으면 2ab 이런식으로 만들어줌
						compressString += (cnt + unit);
					} else { // 아니면 고대로
						compressString += unit;
					}
					cnt = 1; // cnt 초기화
					unit = temp;
					// System.out.println("unit : " + unit);
				}
			}

			if (cnt > 1) {
				compressString += (cnt + unit);
			} else {
				compressString += unit;
			}

			answer = answer > compressString.length() ? compressString.length() : answer;
		}

		if (answer == 99999999) {
			answer = 1;
		}

		return answer;
	}
}