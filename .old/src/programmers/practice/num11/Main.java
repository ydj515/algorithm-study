import java.util.*;
class Solution {
	public int solution(int n) {

		// n까지 크기의 판별 배열 생성
		boolean[] isNotPrime = new boolean[n + 1];

		isNotPrime[0] = true;
		isNotPrime[1] = true;
		// 0과 1은 소수에서 제외

		int answer = 0;
		// 소수 개수 카운트 할 변수
		for (int i = 2; i <= n; i++) {
			// 2부터 n보다 작거나 같은 동안 반복
			if (isNotPrime[i] == false) {
				// 숫자 i가 소수로 체크되어 있지 않다면
				answer++;
				// 소수 발견! 소수 하나 체크하고
				for (int j = i + i; j <= n; j += i) {
					// 그 배수를 시작으로 j가 n 보다 커지기 전까지 i만큼 더해가며
					isNotPrime[j] = true;
					// 그 배수들은 소수가 아니라고 체크한다
				}
			}
		}

		return answer;

	}

}