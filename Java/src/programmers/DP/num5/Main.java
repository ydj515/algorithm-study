import java.util.*;
class Solution {

	static int length;
	int[][] memoization = new int[2001][2001]; // 0으로 초기화

	public int solution(int[] left, int[] right) {

		length = left.length;
		int answer = solve(0, 0, left, right);

		// System.out.println("답 : " + answer);

		return answer;
	}

	int solve(int L, int R, int[] left, int[] right) // 함수의 정의 : 최종 점수의 최대값 출력.
	{
		// 종료 조건
		// 카드를 한쪽만이라도 다 버렸으면
		// 왼쪽이든 오른쪽이든 length만큼 다 소모 해버리면 종료
		if (L == length || R == length) {
			return 0;
		}

        
		int max = memoization[L][R];
        if(max >0) return max;
        
		// <<점수 없는 경우>>
		// 왼쪽 카드만 버릴 경우
		// 왼쪽 오른쪽 둘다 버릴 경우
		memoization[L][R] = Math.max(solve(L + 1, R, left, right), solve(L + 1, R + 1, left, right));
		// System.out.println("첫 max : " + max);

		// <<점수 있는 경우>>
		// 왼 > 오 인 경우
		if (left[L] > right[R]) {
			memoization[L][R] = Math.max(max, solve(L, R + 1, left, right) + right[R]);
		}
		// System.out.println("두번째 max : " + max);

		return memoization[L][R];
	}
}