import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
      int[] corrects = new int[3];
      
      int[] first = { 1, 2, 3, 4, 5};
      int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
      int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

      for (int i = 0; i < answers.length; i++) {
         // 첫번재 수포자
         if ((answers[i] == first[i % 5])) {
            corrects[0]++;
         }
         // 두번째 수포자
         if (answers[i] == second[i % 8]) {
            corrects[1]++;
            }
         // 세번째 수포자
         if (answers[i] == third[i % 10]) {
            corrects[2]++;
            }
      }

      int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));

      List<Integer> al = new ArrayList<>();

      for (int i = 0; i < corrects.length; i++) {
         if (max == corrects[i]) {
            al.add(i+1);
         }
      }
        
      int[] finalArr = new int[al.size()];
        // Collections.sort(al);
        
      for (int i = 0; i < al.size(); i++) {
         finalArr[i] = al.get(i);
      }
        return finalArr;
    }
}