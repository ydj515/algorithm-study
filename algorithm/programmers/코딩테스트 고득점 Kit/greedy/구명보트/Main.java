import java.util.*;
class Solution {
	public int solution(int[] people, int limit) {
        
        // arraylist remove로 처음에 했다가 시간 초과났다.
        // 그래서 remove하지말고 pointer로 움직이는 방식으로 접근

		int answer = 0;

        Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));

		// 내림차순 정렬
        // 3명이상이 탈수있다면 조건이 더 까다로워지겠지만 어짜피 미달이어도 최대 2명뿐이라서 젤 가벼운 사람부터 태워도 무방
		arrayList.sort(Comparator.reverseOrder());

		// 가장 큰 수와 가작 작은수를 배에 태워 보내면 됨
		int right = people.length-1; // 젤 작은애 index
		int left = 0 ; // 젤 큰애 index
		
		while (right > left) { // 양측 left, right 포인터를 점점 가운데로 모아가면서 비교. if문으로 break 하면 시간초과 나서 while 조건으로 걸어줌
            
            // 두개 합친게 limit 이하이면 그 다음 가벼운, 그다음 무거운애들로 비교

			if( arrayList.get(left) + arrayList.get(right) <= limit ) {
                right--;
            }
            
            left++;
			
			answer++;
		}
		
		if ( left == right ) { // 옮길 사람이 한명만 남았다면 그사람 +1 해주면 되므로 
            answer++;   
        }
		
		return answer;
	}
}