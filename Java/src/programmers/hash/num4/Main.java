package programmers.hash.num4;

import java.util.*;
class Solution {
	public int[] solution(String[] genres, int[] plays) {

		List<Integer> answerPlayTimeList = new ArrayList<>(); // playTime 담는 ArrayList
		List<Integer> answerPlayTimeIndexList = new ArrayList<>(); // 임시 arrayList 선언

		// 고유번호 : 플레이 횟수
		Map<Integer, Integer> howToManyPlayMap = new HashMap<Integer, Integer>();

		// 고유번호 : 장르 이름
		Map<Integer, String> genreMap = new HashMap<Integer, String>();

		for (int i = 0; i < genres.length; i++) {
			howToManyPlayMap.put(i, plays[i]);
			genreMap.put(i, genres[i]);
		}
		// System.out.println(howToManyPlayMap);
		// System.out.println(genreMap);

		// 장르 중복제거 후 HashSet에 담기
		HashSet<String> genreSet = new HashSet<String>();

		for (int i = 0; i < genres.length; i++) {
			genreSet.add(genres[i]);
		}
		// System.out.println(genreSet);

		// 장르별 총 플레이 횟수
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		Iterator it = genreSet.iterator();

		while (it.hasNext()) {
			int cnt = 0;
			String s = (String) it.next();
			System.out.println(s);
			for (int i = 0; i < genreMap.size(); i++) {
				if (genreMap.get(i).equals(s)) {
					cnt += howToManyPlayMap.get(i);
				}
			}
			hashMap.put(cnt, s);
		}

		// System.out.println(hashMap);
		// System.out.println("------------sort 전 -------------");
		Iterator it1 = hashMap.keySet().iterator();
		while (it1.hasNext()) {
			int temp = (int) it1.next();
			// System.out.println(temp + " = " + hashMap.get(temp));
		}

		// key를 기준으로 정렬
		// TreeMap 이용
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(hashMap);
		// Iterator<Integer> iteratorKey = tm.keySet().iterator(); // 키값 오름차순 정렬(기본)

		Iterator<Integer> iteratorKey = tm.descendingKeySet().iterator(); // 키값 내림차순 정렬

		// value를 기준으로 정렬
		// static Method 이용
		// Iterator it2 = sortByValue(hashSet).iterator();

		System.out.println("------------sort 후 -------------");
		while (iteratorKey.hasNext()) {
			int index = (int) iteratorKey.next();
			// System.out.println(index + " = " + hashMap.get(index));

			Iterator it2 = genreMap.keySet().iterator();
			List<Integer> list = new ArrayList<>(); // 임시 arrayList 선언

			while (it2.hasNext()) {
				int genreIndex = (int) it2.next();
				// System.out.println(genreIndex);
				// System.out.println("gmap : " + genreMap.get(genreIndex));
				// System.out.println("haspMap : " + hashMap.get(index));

				if (genreMap.get(genreIndex).equals(hashMap.get(index))) {
					// System.out.println("paly time : " + howToManyPlayMap.get(genreIndex));
					list.add(howToManyPlayMap.get(genreIndex)); // 임시 배열에 각 장르의 플레이 타임 넣기
				}

			}
			Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
			// System.out.println("--------------------------------");
			// System.out.println("list" + list);

			// 최대 개수 2개 까지만 추가
			if (list.size() < 2) { // 사이즈가 1이라면 1개만 추가
				answerPlayTimeList.add(list.get(0));
			} else { // 사이즈가 2 이상이면 2개만 추가
				for (int i = 0; i < 2; i++) {
					answerPlayTimeList.add(list.get(i));
				}
			}

			list.clear();

		}
		// System.out.println("--------------------------------");
		// System.out.println(answerPlayTimeList);
		// System.out.println("--------------------------------");

		for (int i = 0; i < answerPlayTimeList.size(); i++) {
			Iterator it3 = howToManyPlayMap.keySet().iterator();

			while (it3.hasNext()) {
				int n = (int) it3.next();
				if (howToManyPlayMap.get(n) == answerPlayTimeList.get(i)) {
					answerPlayTimeIndexList.add(n);
				}
			}

		}

		// System.out.println(answerPlayTimeIndexList);
		int[] answer = new int[answerPlayTimeIndexList.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerPlayTimeIndexList.get(i);
			// System.out.print(answer[i] + " ");
		}

		return answer;
	}
	// 별도의 스태틱 함수로 구현

// 	public static List sortByValue(final Map map) {

// 		List<String> list = new ArrayList();

// 		list.addAll(map.keySet());

// 		Collections.sort(list, new Comparator() {

// 			public int compare(Object o1, Object o2) {

// 				Object v1 = map.get(o1);

// 				Object v2 = map.get(o2);

// 				return ((Comparable) v2).compareTo(v1);

// 			}

// 		});

// 		// Collections.reverse(list); // 주석시 오름차순

// 		return list;
// 	}
}}