class Solution {
    static int n;
    public int solution(int[] diffs, int[] times, long limit) {
            int answer = 0;
            n = diffs.length;
            // limit이 10의 15승까지이기 때문에 long 사용
            long start = diffs[0];
            long end = 0;

            for (int i = 0; i < diffs.length; i++) {
                end = (int) Math.max(end, diffs[i]);
            }

            answer = (int) end;

            // binary search
            while (start <= end) {
                long mid = (start + end) / 2;
                if (check(mid, diffs, times, limit)) {
                    end = mid - 1;
                    answer = (int) Math.min(mid, answer);
                } else {
                    start = mid + 1;
                }
            }
            return answer;
        }

        static boolean check(long value, int[] diffs, int[] times, long limit) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (diffs[i] <= value) {
                    sum += times[i];
                } else {
                    sum += ((times[i - 1] + times[i]) * (diffs[i] - value) + times[i]);
                }
            }
            return sum <= limit;
        }
}