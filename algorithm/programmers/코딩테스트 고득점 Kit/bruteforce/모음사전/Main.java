import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<String> wordList = new ArrayList<>();
    Set<String> combinationSet = new HashSet<>(); // 01과 1의 경우 동일하기 때문에 HashSet으로 중복 검사
    List<String> tempList = new ArrayList<>();

    public int solution(String word) {

        String[] worldArr = new String[]{"A", "E", "I", "O", "U"};

        wordList = Arrays.stream(worldArr).collect(Collectors.toList());

        LinkedList<String> perArr = new LinkedList<>();
        int[] perCheck = new int[wordList.size()];

        // 순열 nPr
        for (int i = 1; i <= wordList.size(); i++) {
            permutation(wordList.size(), i, perArr, perCheck);
        }

        Iterator<String> it = combinationSet.iterator();

        while (it.hasNext()) {
            String n = it.next();
            tempList.add(n);
        }

        Collections.sort(tempList);

        return tempList.indexOf(word) + 1;
    }

    public void permutation(int n, int r, LinkedList<String> perArr, int[] perCheck) {

        if (perArr.size() == r) {
            String temp = "";

            for (String i : perArr) {
                temp += i;
            }

            combinationSet.add(temp); // 중복 검사 ex) 1, 01은 동일하게 1로 insert

            return;
        }

        for (int i = 0; i < n; i++) {

            // 중복순열이기에 check부분 주석
            // 일반 순열이면 중복 체크해서 방문했던 것이면 방문 x
//            if (perCheck[i] == 0) {
            perArr.add(wordList.get(i));
            perCheck[i] = 1;
            permutation(n, r, perArr, perCheck);
            perCheck[i] = 0;
            perArr.removeLast();
//            }
        }

    }
}