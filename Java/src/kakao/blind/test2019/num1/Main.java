package kakao.blind.test2019.num1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static String[] main(String[] record) {

		int cnt = 0;
		List<String> ansList = new ArrayList<String>(); // 답을 임시로 저장
		Map<String, String> idMap = new HashMap<String, String>();

		for (String str : record) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			String cmd = tokenizer.nextToken();

			if (cmd.equals("Enter") || cmd.equals("Change")) { // id가 바뀔수 있는 경우
				String id = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				idMap.put(id, name); // Enter로 최초로 들어오면 map에 추가될 것이고, change라고 하면 value에 해당하는 name값이 변경될 것이다.
			}
		}

		cnt = idMap.size();

		for (String str : record) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			String cmd = tokenizer.nextToken();

			if (cmd.equals("Enter")) {
				String id = tokenizer.nextToken();
				ansList.add(idMap.get(id) + "님이 들어왔습니다.");
			} else if (cmd.equals("Leave")) {
				String id = tokenizer.nextToken();
				ansList.add(idMap.get(id) + "님이 나갔습니다.");
			}
		}

		String[] answer = new String[ansList.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = ansList.get(i);
		}

		return answer;

	}

}
