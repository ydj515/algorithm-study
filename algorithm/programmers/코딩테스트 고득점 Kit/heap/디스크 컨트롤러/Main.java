import java.util.*;
class Solution {
    class Job {
        private final int start;
        private final int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        public int getStart() {
            return start;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", time=" + time +
                    '}';
        }
    }

    public int solution(int[][] jobs) {

        // 시간이 가장 짧게 걸리려면 소요작업이 짧은 순으로 해결
        int answer = 0;
        List<Job> jobList = new ArrayList<>();

        for (int[] job : jobs) {
            jobList.add(new Job(job[0], job[1]));
        }

        Collections.sort(jobList, Comparator.comparing(Job::getTime));
        
        int currentTime = 0;
        int sum = 0;

        while (!jobList.isEmpty()) {
            // 가장 빨리 시작할 수 있는 작업 찾기
            Job nextJob = null;
            for (Job job : jobList) {
                if (currentTime >= job.start) {
                    nextJob = job;
                    break;
                }
            }

            if (nextJob != null) { // 작업을 시작할 수 있는 경우
                currentTime += nextJob.time;
                sum += currentTime - nextJob.start;
                jobList.remove(nextJob);
            } else { // 작업을 시작할 수 없는 경우
                // 작업 시작 시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
                // start : 26, time : 1
                // start : 15, time : 2
                // start : 37, time : 5
                currentTime++;
            }
        }

        return sum / jobs.length;
    }
}