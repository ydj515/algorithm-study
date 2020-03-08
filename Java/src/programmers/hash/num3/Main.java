package programmers.hash.num2;

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1; // 곱셈을 위해 1로 선언
		
		HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();

		// map 구하기
		for (int i = 0; i < clothes.length; i++) {
			// 의상종류, 갯수
			// getOrDefault(key, defaultValue)
			// => 찾는 키가 존재한다면 찾는 키의 값return 아니면 defaultValue return
			clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
		}
		// 조합
		Set<String> keySet = clothesMap.keySet(); // 의상종류.
        
		System.out.println(keySet);
        System.out.println(clothesMap);
		Iterator<String> it = clothesMap.keySet().iterator();

		while (it.hasNext()) {
            System.out.println("answer : " + answer);
            answer *= clothesMap.get(it.next()) + 1;
		}

		return answer - 1; // 아무것도 안입는 경우의 수 제거
    }
}
