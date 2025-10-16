### 문제

https://school.programmers.co.kr/learn/courses/30/lessons/42747

#### 1\. 문제의 재정의

기존 문제: "조건을 만족하는 h의 **최댓값**은 얼마인가?"
➡️ 이분 탐색을 위한 결정 문제: "**h가 `mid`일 때, H-Index 조건을 만족하는가?**" (Yes/No)

구하려는 값(`h`)의 범위를 정해놓고 특정 `h`가 정답이 될 수 있는지 없는지를 판별하여 범위를 좁혀나가는 **파라메트릭 서치(Parametric Search)** 기법을 적용할 수 있습니다.

#### 2\. 탐색 범위 설정

  * `left = 0`: H-Index는 0일 수 있습니다 (논문이 하나도 인용되지 않은 경우).
  * `right = n`: H-Index는 총 논문의 수(`n`)를 넘을 수 없습니다.

#### 3\. `mid` 값이 H-Index 조건에 맞는지 확인하는 방법

`mid`를 `h`의 후보라고 생각하고, " `mid`번 이상 인용된 논문이 `mid`편 이상인가?"를 확인합니다.

1.  `citations` 배열을 순회합니다.
2.  각 논문의 인용 횟수(`citation`)가 `mid` 이상인 논문의 개수(`count`)를 셉니다.
3.  만약 `count`가 `mid`보다 크거나 같다면, `mid`는 H-Index의 조건을 만족하는 것입니다.

#### 4\. 탐색 범위 갱신

  * **`count >= mid` (조건 만족):**
    `mid`가 H-Index 후보가 될 수 있다는 의미입니다. 하지만 우리는 `h`의 **최댓값**을 찾아야 하므로, 더 큰 `h`도 가능한지 알아봐야 합니다. 따라서 `mid`를 정답 후보로 저장하고, 탐색 범위를 오른쪽으로 옮깁니다 (`left = mid + 1`).

  * **`count < mid` (조건 불만족):**
    `mid`는 H-Index가 될 수 없습니다. `mid`보다 큰 값들 역시 당연히 조건을 만족할 수 없으므로, 탐색 범위를 왼쪽으로 옮깁니다 (`right = mid - 1`).

이 과정을 `left <= right`일 때까지 반복하면 최적의 해를 찾을 수 있습니다.

-----

### \#\# Java 코드 예시

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        // h의 가능한 범위를 0부터 n까지로 설정
        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2; // h의 후보

            // mid번 이상 인용된 논문이 몇 편인지 계산
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }

            if (count >= mid) {
                // 조건을 만족 -> h가 더 커질 수 있는지 확인
                answer = mid; // 현재 mid는 유효한 h이므로 정답 후보로 저장
                left = mid + 1;
            } else {
                // 조건을 만족하지 못함 -> h가 더 작아져야 함
                right = mid - 1;
            }
        }

        return answer;
    }
}
```

### \#\# 정렬 풀이 vs. 이분 탐색 풀이

|            | 정렬 후 선형 탐색                     | 이분 탐색 (파라메트릭 서치)                          |
|:-----------|:-------------------------------|:------------------------------------------|
| **시간 복잡도** | $O(N \log N)$                  | $O(N \log N)$                             |
| **설명**     | 정렬($O(N \log N)$) + 탐색($O(N)$) | 이분탐색($O(\log N)$) \* 각 탐색마다 배열 순회($O(N)$) |
| **장점**     | 구현이 더 직관적이고 간단할 수 있음           | "최적화 문제를 결정 문제로" 바꾸는 강력하고 범용적인 사고방식을 적용   |

결론적으로, 두 방법 모두 시간 복잡도는 $O(N \log N)$으로 동일합니다. 이 문제에 한해서는 정렬 후 선형 탐색하는 코드가 더 간결하고 직관적일 수 있지만, 이분 탐색으로도 충분히 풀 수 있으며, 이는 문제 해결 능력을 보여주는 좋은 접근 방식입니다.