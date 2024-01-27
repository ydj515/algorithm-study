import java.util.*;

public class Main {

	public String solution(String[] participant, String[] completion) {

		String answer = "";

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < completion.length; i++) {
			if (map.containsKey(completion[i])) { // participant의 중복된 이름이 있으면 count+1
				int count = map.get(completion[i]);
				map.put(completion[i], count + 1);
			} else { // 중복된 이름이 없으면 count를 1로 넣는다.
				map.put(completion[i], 1);
			}
		}
		Set set = map.entrySet();
		System.out.println(set);

		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i])) {
				if (map.get(participant[i]) == 1) { // count가 1 이라면 map에서 remove
					map.remove(participant[i]);
				} else { // count가 2이상이면 한개 제거했다는 방식으로 count 1 감소하고 count값 갱신
					int count = map.get(participant[i]);
					map.put(participant[i], count - 1);
				}
			} else {
				answer = participant[i];
			}
		}

		return answer;
	}

}
