class Solution {
  public long solution(int a, int b) {
        long answer = 0;

		if (a >= b) {
			for (int i = a; i >= b; i--) {
				answer += i;
			}
		} else {import java.util.*;
		class Solution {
			public boolean solution(String s) {

				boolean answer = true;

				// 문자열 길이 체크
				if (4 > s.length() || 6 < s.length() || s.length() == 5) {
					return false;
				}

				for (int i = 0; i < s.length(); i++) {
					try {
						// Character.getNumericValue(s.charAt(i))로 판단하면 'a' => 10으로 바꿀 수 있기 때문에 판단이 안됨.
						// 따라서 String으로 변환 후 판단
						String ss = Character.toString(s.charAt(i));
						Integer.parseInt(ss);
					} catch (Exception e) {
						return false;
					}
				}

				return answer;
			}
		}
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		}
      
      return answer;
  }
}