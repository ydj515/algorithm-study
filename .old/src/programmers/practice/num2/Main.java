class Solution {
  public String solution(String s) {
      String answer;
      
      if (s.length() % 2 == 0) {
			answer = Character.toString(s.charAt((s.length() / 2) - 1));
			answer += Character.toString(s.charAt((s.length() / 2)));
		} else {
			answer = Character.toString(s.charAt(s.length() / 2));
			System.out.println(answer);
		}
      
      return answer;
  }
}