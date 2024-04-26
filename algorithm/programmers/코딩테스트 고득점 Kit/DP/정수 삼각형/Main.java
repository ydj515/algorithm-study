class Solution {
	public int solution(int[][] triangle) {
		
		int[][] memoization = new int[triangle.length][triangle.length];

		// 7 
		// 3 8 
		// 8 1 0 
		// 2 7 4 4 
		// 4 5 2 6 5 
		// 여기서 왼쪽 쭉, 오른쪽은 나올 수 있는 경우가 1가지이다.
		memoization[0][0] = triangle[0][0]; // 최 상위 루트값 집어 넣음
		
		for (int i = 1; i < triangle.length; i++) {
			memoization[i][0] = memoization[i - 1][0] + triangle[i][0];
			memoization[i][i] = memoization[i - 1][i - 1] + triangle[i][i];
		}
		
		// << 수행 결과 >>
		// 7  0  0  0  0  
		// 10 15 0  0  0  
		// 18 0  15 0  0  
		// 20 0  0  19 0  
		// 24 0  0  0  24 
		
		// 중간 값들은 경우가 2가지 이므로 Math.max로 최댓값 저장해주면 됨
		for (int i = 2; i < triangle.length; i++) {
			for (int j = 1; j < i; j++) {
				memoization[i][j] = Math.max(memoization[i - 1][j - 1], memoization[i - 1][j]) + triangle[i][j];
			}
		}
		// << 수행 결과 >>	
		// 7  0  0  0  0  
		// 10 15 0  0  0  
		// 18 16 15 0  0  
		// 20 25 20 19 0  
		// 24 30 27 26 24 

		int answer = memoization[memoization.length - 1][0];
		for (int i = 1; i < memoization.length; i++) {
			answer = Math.max(answer, memoization[memoization.length - 1][i]);
		}
		
		return answer;
	}
}