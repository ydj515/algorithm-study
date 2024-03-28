class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n]; // 0으로 초기화

        for (int j : lost) { // 잃어버린애들은 -1
            students[j - 1] -= 1;
        }

        for (int j : reserve) { // 여분갖고 있는 애들은 +1
            students[j - 1] += 1;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == -1) {
                if (i == 0) { // 첫번째 index
                    if (students[i + 1] == 1) {
                        students[i + 1] = 0;
                        students[i] = 0;
                    }
                } else if (i == students.length - 1) { // 마지막 index
                    if (students[i - 1] == 1) {
                        students[i - 1] = 0;
                        students[i] = 0;
                    }
                } else {
                    if (students[i - 1] == 1) {
                        students[i - 1] = 0;
                        students[i] = 0;
                    } else if (students[i + 1] == 1) {
                        students[i + 1] = 0;
                        students[i] = 0;
                    }
                }
            }
        }

        return (int) Arrays.stream(students).filter(i -> i >= 0).count();

    }
}