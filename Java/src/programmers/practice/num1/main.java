class Solution {
  public String solution(int a, int b) {
      String answer = "";
      
      int day[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 2016년 1월 1일은 금요일
		String[] date = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED",  };

		int sum = 0;

		for (int i = 0; i < a - 1; i++) {
			sum += day[i];
			System.out.println(sum);
		}
		sum += b;
      
      return date[(sum) % 7];
  }
}