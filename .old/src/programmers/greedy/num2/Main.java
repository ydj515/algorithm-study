import java.util.*;
class Solution {
    public int solution(String name) {

        int answer = 0;
        int now = 0;

        String tempString = "";
        String name2 = name.toString();

        // System.out.println(name2);
        for (int i = 0; i < name.length(); i++) {
            tempString += "A";
        }

        // N(13)을 기준으로 좌우 판단
        // 알파벳 몇 칸 움직여야하는지 판단
        for (int i = 0; i < name.length(); i++) {

            if (name.charAt(i) - 'A' > 13) {
                answer += 'Z' - name.charAt(i) + 1;
                // System.out.println('Z' - name.charAt(i) + 1);
            } else {
                answer += name.charAt(i) - 'A';
                // System.out.println(name.charAt(i) - 'A');
            }
        }

        System.out.println("answer : " + answer);

        // 맨 왼쪽에서 오른쪽으로 쭉 가는거
        int count = 0;

        for (int i = 1; i < name.length(); i++) {
            if (tempString.equals(name)) {
                break;
            }
            count++;
            if (name.charAt(i) != 'A') {

                StringBuilder myName = new StringBuilder(name);
                myName.setCharAt(i, 'A');
                name = myName.toString();
                System.out.println(name);
            }
            System.out.println("count : " + count);
        }
        System.out.println(count);


        // 맨 오른쪽에서 왼쪽으로 쭉 가는거
        int count2 = 0;

        if (name2.charAt(0) != 'A') {
            StringBuilder myName = new StringBuilder(name2);
            myName.setCharAt(0, 'A');
            name2 = myName.toString();
        }

        System.out.println("name2 : " + name2);

        for (int i = name.length() - 1; i >= 1; i--) {
            if (tempString.equals(name2)) {
                break;
            }
            count2++;
            if (name2.charAt(i) != 'A') {

                StringBuilder myName = new StringBuilder(name2);
                myName.setCharAt(i, 'A');
                name2 = myName.toString();
                System.out.println(name2);
            }
        }
        System.out.println(count2);

        answer += Math.min(count, count2);

        System.out.println("answer : " + answer);

        return answer;
    }
}