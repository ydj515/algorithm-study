import java.util.*;
class Solution {

    public int solution(int N, int number) {
        ArrayList<Set<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> curSet = list.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(i - j);

                for (int num1 : set1) {
                    for (int num2 : set2) {
                        curSet.add(num1 + num2);
                        curSet.add(num1 - num2);
                        curSet.add(num1 * num2);
                        if (num2 != 0) {
                            curSet.add(num1 / num2);
                        }
                    }
                }

                curSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

        }
        for (Set<Integer> sub : list) {
            if (sub.contains(number)) {
                return list.indexOf(sub);
            }
        }
        return -1;
    }
}