import java.util.*;
class Solution {

	static boolean[] visit;
	static int n = 0;

	public int solution(String begin, String target, String[] words) {

		int answer = 0;

		visit = new boolean[words.length]; // 방문했는지 여부

		// 연산을 쉽게 하기 위해서 arraylist로 변환 후 넘겼다.
		// dfs함수 안에서 변환해도 되지만 계쏙 호출이 되는 recursion이라 new를 계속 해야되서 변환하고 넘겻다 브로
		List<String> wordList = new ArrayList<String>(Arrays.asList(words));

		int cnt = begin.length() - 1; // 글자를 변환할 수 있는지 체크하는 변수. 주어진 글자보다 1만 작아야 변환가능(한능 글자만 달라야 변환 가능)

		answer = dfs(begin, target, wordList, cnt);

		return answer;
	}

	public int dfs(String begin, String target, List<String> wordList, int cnt) {

		for (int i = 0; i < wordList.size(); i++) {

			int count = 0; // begin과 worldlist의 string의 글자수 일치갯수
			int targetcount = 0;

			if (visit[i] == false) {

				for (int j = 0; j < begin.length(); j++) {

					System.out.println("begin : " + begin.charAt(j) + ", " + "worldlist : " + wordList.get(i).charAt(j));

					// begin의 글자 한개씩 비교
					if (begin.charAt(j) == wordList.get(i).charAt(j)) {
						count++;
						System.out.println("count++ => " + count);
					}

					// 한글자씩 바꾼 단어들이 마지막 target 단어와 같으면
					if (begin.charAt(j) == target.charAt(j)) {
						targetcount++;
						System.out.println("targetcount++ => " + targetcount);
					}
				}
			} else {
				System.out.println("visit를 했기때문에 pass");
			}

			System.out.println("=============================");

			if (targetcount == cnt) { // 한글자씩 바꾼 단어들이 마지막 target 단어와 같으면
				n++;
				System.out.println("targetcount와 cnt 같앙");
				return n; // dfs 종료
			}

			if (count == cnt) { // begin과 worldlist의 string의 글자수 일치갯수와 절대적 cnt가 같다면
				begin = wordList.get(i); // begin을 다음 단어로 바꾸고
				n++;
				visit[i] = true; // 방문했다고 표시

				return dfs(begin, target, wordList, cnt); // 재귀 호출
			}
		}

		return 0; // 변환할 수 있는 단어가 애초에 없으면 0
	}
}