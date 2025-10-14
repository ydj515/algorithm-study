import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] baseball) {

        List<Integer> list = new ArrayList<>();
        List<Integer> answerTempList = new ArrayList<>();

        // 전체 나올 수 있는 야구 게임의 경우의 수
        for (int i = 123; i <= 987; i++) {

            String temp = String.valueOf(i); // 자리 비교하기에 String이 편해서 변환했음

            if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || temp.charAt(2) == temp.charAt(0) || // 중복 검사
                    temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0') // 0 유무 검사
                continue;

            list.add(Integer.parseInt(temp));
        }

        // System.out.println(list);


        for (int i = 0; i < baseball.length; i++) {

            String baseballTemp = String.valueOf(baseball[i][0]); // 입력 받은 볼
            // System.out.println("======");
            // System.out.println(baseballTemp);


            int strike = 0;
            int ball = 0;


            for (int j = 0; j < list.size(); j++) {

                String listTemp = String.valueOf(list.get(j)); // 리스트에서 하나씩 꺼냄
                // System.out.println(listTemp);

                // count strike
                strike = IntStream.range(0, 3).map(k -> (baseballTemp.charAt(k) == listTemp.charAt(k)) ? 1 : 0).sum();

                // count  ball
                ball = IntStream.range(0, 3).map(k -> ((baseballTemp.charAt(k) == listTemp.charAt((k + 1) % 3)) || (baseballTemp.charAt(k) == listTemp.charAt((k + 2) % 3))) ? 1 : 0).sum();

                // System.out.println("strike : " + strike + ", ball : " + ball);

                if(strike == baseball[i][1] && ball == baseball[i][2]) {
                    answerTempList.add(list.get(j)); // 될 수 있는 후보군을 임시로 담는 list
                }

            }

            list.clear();
            list.addAll(answerTempList); // 후보군 list를 정답지로 대체
            answerTempList.clear();
        }

        // System.out.println(list);

        return list.size();
    }
}