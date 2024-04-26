import java.util.*;
class Solution {
	public int solution(int m, int n, int[][] puddles) {

		int answer = 0;
		int[][] memoization = new int[n + 1][m + 1];

		memoization[1][1] = 1;// 시작위치를 1로 초기화

		// 웅덩이들 -1로 초기화
        // 1을 더하니까 0이 되는거임
		for (int[] puddle : puddles) {
			memoization[puddle[1]][puddle[0]] = -1;
		}
		
		//  0  0  0  0  0
		//  0  1  0  0  0
		//  0  0 -1  0  0
		//  0  0  0  0  0

		for (int i = 1; i < memoization.length; i++) {
			for (int j = 1; j < memoization[i].length; j++) {
				// 웅덩이는 0 으로 바꾸고 넘어감.
				if (memoization[i][j] == -1) {
					memoization[i][j] = 0;
				} else { // 더하는 과정
					if (i == 1) { // 시작점이면서 각 왼쪽 위쪽 사이드라면
						memoization[i][j] += memoization[i][j - 1];
					} else {
						memoization[i][j] = (memoization[i - 1][j] + memoization[i][j - 1]) % 1000000007;
					}
				}
			}
		}
		
		//  0  0  0  0  0
		//  0  1  1  1  1
		//  0  1  0  1  2
		//  0  1  1  2  4

		answer = memoization[memoization.length - 1][memoization[0].length - 1]; // 마지막 값이 정답
		
		return answer;
	}
}