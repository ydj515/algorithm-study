import java.util.*; 
class Solution {
    static ArrayList<String> al = new ArrayList<>();
    static Set<String> combinationSet = new HashSet<>(); // 01과 1의 경우 동일하기 때문에 HashSet으로 중복 검사

    public int solution(int n, String[] data) {
        int answer = 0;

        String[] array = {"A", "C", "F", "J", "M", "N", "R", "T"};
        for (int i = 0; i < array.length; i++) {
            al.add(array[i]);
        }

        LinkedList<String> perArr = new LinkedList<>();
        int[] perCheck = new int[al.size()];

        // 순열 nPr. 8P8
        permutation(array.length, array.length, perArr, perCheck);
        // System.out.println("===============");
        // System.out.println(combinationSet);
        // System.out.println(combinationSet.size());

        // 조건 검사
        Iterator<String> iter = combinationSet.iterator();
        while (iter.hasNext()) {
            String inputString = iter.next();
            boolean is_ok = true;

            for (int i = 0; i < data.length; i++) {
                if (!checkRule(inputString, data[i])) {
                    is_ok = false;
                    break;
                }
            }

            if (is_ok) {
                answer++;
            }
        }

        // System.out.println(answer);
        return answer;
    }

    // 순열 (순서있게 배열)
    public static void permutation(int n, int r, LinkedList<String> perArr, int[] perCheck) {
        if (perArr.size() == r) {
            String temp = "";

            for (String i : perArr) {
                temp += i;
            }
            combinationSet.add(temp); // 중복 검사 ex) 1, 01은 동일하게 1로 insert
            // System.out.println(temp);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (perCheck[i] == 0) {
                perArr.add(al.get(i));
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }

    }

    // 조건 확인
    Boolean checkRule(String inputString, String rule) {
        char a = rule.charAt(0); // 첫번째 아이
        char b = rule.charAt(2); // 두번째 아이
        char op = rule.charAt(3); // 부등호
        int digit = rule.charAt(4) - '0'; // 숫자
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == a || inputString.charAt(i) == b) {
                for (int j = i + 1; j < inputString.length(); j++) {
                    if (inputString.charAt(j) == a || inputString.charAt(j) == b) {
                        if (op == '=' && digit != j - i - 1) {
                            return false;
                        } else if (op == '>' && j - i - 1 <= digit) {
                            return false;
                        } else if (op == '<' && j - i - 1 >= digit) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
