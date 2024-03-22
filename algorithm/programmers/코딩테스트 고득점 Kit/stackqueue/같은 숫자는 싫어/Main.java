import java.util.*;

class Solution {
        public int[] solution(int[] arr) {
            
        List<Integer> list = new ArrayList<>();
        int test = arr[0];
        list.add(test);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != test) {
                list.add(arr[i]);
                test = arr[i];
            }

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}