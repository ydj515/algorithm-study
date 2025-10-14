import java.util.*;
class Solution {
	public int solution(String skill, String[] skill_trees) {

		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			int index = 0;
			boolean flag = true;
			int count = 0; // 얼마나 맞추는지 count하는 변수를 사용하려 했으나 AECB의 경우 count 갯수로 비교할 수 없어서 flag 사용

			System.out.println(skill_trees[i]);
			for (int j = 0; j < skill_trees[i].length(); j++) {
				for (int k = index; k < skill.length(); k++) {
					System.out.println("skill.charAt(k) : " + skill.charAt(k) + ", skill_trees[i].charAt(j) : " + skill_trees[i].charAt(j));
					if (skill.charAt(k) == skill_trees[i].charAt(j)) { // skill의 문자 하나랑 skill tree 하나의 요소(BACDE)를 꺼내와서 비교
						if (k != index) {
							flag = false;
						} else {
							count++;
							index++;
						}
					}
				}
				System.out.println("===================");
			}

			if (flag == true) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}
}