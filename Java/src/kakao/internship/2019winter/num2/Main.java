import java.util.*;
class Solution {
	public int[] solution(String s) {

		// 괄호 콤마 다 짜름
		String ss = s.replace("{", "").replace("},", "/").replace("}", "");

		// 중간에 콤마 삽입시켜줌
		// [2, 2,1, 2,1,3, 2,1,3,4]
		List<String> tempList = new ArrayList<>(Arrays.asList(ss.split("/")));

		// [2]
		// [2, 1]
		// [2, 1, 3]
		// [2, 1, 3, 4]
		List<List<String>> finalList = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			finalList.add(new ArrayList<>(Arrays.asList(tempList.get(i).split(","))));
		}

		// {2}
		// {2,1}
		// {2,1,3}
		// {2,1,3,4}

		int[] answer = new int[finalList.size()];
		Set<String> set = new HashSet<>();
		
		for (int i = 1; i <= finalList.size(); i++) {
			for (int j = 0; j < finalList.size(); j++) {
				if (finalList.get(j).size() == i) {
					for (int k = 0; k < i; k++) {
						if (!set.contains(finalList.get(j).get(k))) {
							set.add(finalList.get(j).get(k));
							answer[i - 1] = Integer.parseInt(finalList.get(j).get(k));
						}
					}
				}
			}
		}

		// System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));

		return answer;
	}
}