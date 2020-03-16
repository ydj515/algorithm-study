import java.util.*;
class Solution {
	   public String solution(String number, int k) {

	      int index = 0;
	      char max;

	      StringBuilder answer = new StringBuilder(); // 처음에 String에다가 max += 해줬는데 시간초과 나서 builder썻음

	      // 시작을 0으로 주는 파렴치한 짓을 하네;
	      // 예외 처리함
	      if (number.charAt(0) == '0') {
	         return "0";
	      }

	      // 뽑아야 하는 수 : 1 231 234의 7자리 수
	      // k = 3 => 우린 4자리 숫자를 return 해주어야한다.
	      // 그럼 첫 for문에서는 딱 length - k 까지 해주어야한다.
	      // 처음 1231에서 하나 뽑고 그 다음 234를 붙힌다면 숫자가 성립하기 때문이다.
	      // 그럼 i=2 일때도 마찬가지이다.
	      // 계속 뒤에 남은 갯수를 생각하여 두번째 for loop 범위를 지정해주는게 중요

	      for (int i = 0; i < number.length() - k; i++) {

	         max = '0';

	         System.out.println("i : " + i);

	         for (int j = index; j <= k + i; j++) { // max값을 가진 index 부터 비교

	            System.out.println("number.charat(" + j + ") : " + number.charAt(j) + ", max : " + max);

	            if (max < number.charAt(j)) {
	               max = number.charAt(j);
	               index = j + 1; // max값을 가진 index 다음 index부터 비교 하면 되므로 +1 해줌
	            }

	            System.out.println("index : " + index);
	         }

	         answer.append(max);

	         System.out.println(answer);
	      }

	      return answer.toString();
	   }
	}