import java.util.*;
class Solution {
	public int[] solution(String[] words, String[] queries) {

		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			int qjsize = queries[i].length();
			boolean front = false;

			int k = 0;

			// 쿼리문 "?"가 처음에 있는지 아닌지 체크
			if (queries[i].charAt(queries[i].length() - 1) == '?') {
				front = false;
			} else {
				front = true;
				while (queries[i].charAt(k) == '?') {
					k++;
				}
			}

			int ktmp = k;

			for (int j = 0; j < words.length; j++) {
				if (words[j].length() != qjsize) {
					continue;
				}

				for (k = ktmp; k < words[j].length(); k++) {
					if (words[j].charAt(k) != queries[i].charAt(k) && queries[i].charAt(k) != '?') {
						break;
					}

					if (front) {
						if (k == words[j].length() - 1) {
							answer[i]++;
						}

					} else {
						if (queries[i].charAt(k) == '?') {
							answer[i]++;
							break;
						}
					}
				}
			}
		}

		// System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));

		return answer;
	}
}

////////////////////////////// trie를 사용한 정답
import java.util.*;
class Solution {
   public int[] solution(String[] words, String[] queries) {

      int[] answer = new int[queries.length];

      // 접미사(subffix)용 트라이 구조
      Trie[] tries = new Trie[10001];
      // 접두사(prefix)용 트라이 구조
      Trie[] reverseTries = new Trie[10001];

      // words 길이 별 분류

      for (int i = 0; i < words.length; i++) {
         int size = words[i].length();
         // 길이에 해당하는 트라이 만들기
         try {
            tries[size].insert(words[i]);
         } catch (Exception e) {
            tries[size] = new Trie();
            tries[size].insert(words[i]);
         }

         // 반대 문자도 트라이 생성
         words[i] = (new StringBuffer(words[i])).reverse().toString();
         try {
            reverseTries[size].insert(words[i]);
         } catch (Exception e) {
            reverseTries[size] = new Trie();
            reverseTries[size].insert(words[i]);
         }
      }

      // trie 이용하여 해당 쿼리에 맞는 갯수들 찾기
      for (int i = 0; i < queries.length; ++i) {
         String query = queries[i];
         if (query.indexOf('?') == 0) {
            // prefix
            try {
               query = (new StringBuffer(query)).reverse().toString();
               answer[i] = reverseTries[query.length()].search(query);
            } catch (Exception e) {
               continue;
            }
         }

         else {
            // suffix
            try {
               answer[i] = tries[query.length()].search(query);
            } catch (Exception e) {
               continue;
            }
         }
      }

      // System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
      return answer;
   }
}

// Trie Node
class Trie {

   private int count;
   private Trie[] childList;

   public Trie() {
      childList = new Trie[26];
      count = 0;
   }

   public void insert(String word) {
      Trie current = this;

      for (int i = 0; i < word.length(); i++) {
         ++current.count;
         if (current.childList[word.charAt(i) - 'a'] != null) {
            current = current.childList[word.charAt(i) - 'a'];
         } else {
            current.childList[word.charAt(i) - 'a'] = new Trie();
            current = current.childList[word.charAt(i) - 'a'];
         }
      }
   }

   public int search(String query) {
      Trie current = this;

      for (int i = 0; i < query.length(); i++) {
         if (query.charAt(i) == '?') {
            return current.count;
         }

         if (current.childList[query.charAt(i) - 'a'] != null) {
            current = current.childList[query.charAt(i) - 'a'];
         } else {
            return 0;
         }
      }

      return current.count;
   }

}


