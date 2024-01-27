import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        ArrayList<Integer> al = new ArrayList<>();
        int standard = arr[0];
        System.out.println(standard);

        for (int i = 0; i < arr.length; i++) {

            if (standard != arr[i]) {
                al.add(standard);
                standard = arr[i];
            }
            if (i == (arr.length - 1)) {
                al.add(arr[i]);
            }

        }

        int[] answer = new int[al.size()];

        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        // System.out.println(al);

        return answer;
    }
}