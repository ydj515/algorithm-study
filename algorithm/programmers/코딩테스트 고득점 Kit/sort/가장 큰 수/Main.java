import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = Arrays.stream(numbers).boxed().map(Object::toString).collect(Collectors.toList());

        Comparator<String> comparator = (s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2); // 두 숫자를 이어 붙였을 때 더 큰 숫자를 만들어야 함
        };

        Collections.sort(list, comparator);

        System.out.println(list);

        //0000 처럼 0으로만 구성되어있으면 0 return
        if(list.get(0).equals("0")) {
            return "0";
        }

        for (String item : list) {
            answer += item;
        }

        return answer;
    }
}