import java.util.*;
class Solution {
	public int solution(int[][] jobs) {

		// jobs[][]에 있는 작업들은 요청시간 순으로 정렬되어 있지 않음
		/// 같은 요청시간을 갖는 작업들이 2개 이상 존재할 수 있음
		// 시간이 가장 짧게 걸리려면 소요작업이 짧은 순으로 해결
		// compare to 정렬
		List<Job> list = new ArrayList<>();

		for (int i = 0; i < jobs.length; i++) {
			list.add(new Job(jobs[i][0], jobs[i][1]));
		}

		Collections.sort(list);

		int currentTime = 0;
		int sum = 0; // 총 작업 시간

		while (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				// 작업 시작 시간이 현재 시간보다 이전이라면 시작 가능
				if (currentTime >= list.get(i).start) {
					currentTime += list.get(i).time;
					sum += currentTime - list.get(i).start;
					list.remove(i);
					break;
				}

				// 작업 시작 시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
				// start : 26, time : 1
				// start : 15, time : 2
				// start : 37, time : 5
				// 위와 같은 경우 start가 26 이므로 0~25초까지 할게 없다.
				// 이럴 경우 시간을 1씩 증가시키는 것.
				if (i == list.size() - 1) {
					currentTime++;
				}

			}
		}

		// 평균시간을 return
		return (sum / jobs.length);
	}
}

class Job implements Comparable<Job> {
	int start;
	int time;

	public Job(int start, int time) {
		this.start = start;
		this.time = time;
	}

	@Override
	public int compareTo(Job o) {

		int standard = time - o.time; // 끝나는 시간 순으로 정렬

		if (standard == 0) { // 끝나는 시간이 같다면 시작 시간순으로 정렬
			standard = start - o.start;
		}

		return standard;
	}
}