# Algorithm_study

- <a href="https://www.acmicpc.net/">백준</a>
- <a href="https://programmers.co.kr/learn/challenges">프로그래머스</a>
- <a href="http://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/">2019 카카오 신입 공채 1차 코딩 테스트 문제</a>

## Java


### <a href="https://www.acmicpc.net/category/detail/1897">카카오 코드 페스티벌 2018 예선</a>
- 15953(상금 헌터) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num15953/Main.java">풀이</a>
- 15954(인형들) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num15954/Main.java">풀이</a>
- 15956(숏코딩) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num15956/Main.java">풀이</a>


### <a href="https://www.acmicpc.net/category/detail/1945">2018 홍익대학교 컴퓨터공학과 코딩대회</a>
- 16395(파스칼의 삼각형) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16395/Main.java">풀이</a>
- 16396(선그리기) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16396/Main.java">풀이</a>
- 16397(탈출) : **BFS** / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16397/Main.java">풀이</a>
- [x]16398(행성 연결) : **MST Kruskal** / <a href="#">풀이</a> 
- 16400(소수 화폐) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16400/Main.java">풀이</a>
- 16401(과자 나눠주기) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16401/Main.java">풀이</a>
- 16402(제국) : **Union Find** / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16402/Main.java">풀이</a>
- 16404(주식회사 승범이네) : **Segment Tree & Lazy Propagation & DFS Order(전위순회)** / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num16404/Main.java">풀이</a>


### <a href="http://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/">2019 카카오 신입 공채 1차 코딩 테스트 문제</a>
- 1(오픈채팅방) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/kakao/blind/test2019/num1/Main.java">풀이</a>
- 2(실패율) / <a href="#">풀이</a>
- 3(후보키) / <a href="#">풀이</a>
- 4(무지의 먹방 라이브) / <a href="#">풀이</a>
- 5(길 찾기 게임) / <a href="#">풀이</a>
- 6(매칭 점수) / <a href="#">풀이</a>
- 7(블록 게임) / <a href="#">풀이</a>


### <a href="http://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/">UCPC 2019 온라인 예선</a>
- 17362(수학은 체육과목 입니다 2) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num17362/Main.java">풀이</a>
- 17363(우유가 넘어지면?) / <a href="https://github.com/ydj515/Algorithm_study/blob/master/Java/src/num17363/Main.java">풀이</a>

## Python3



## Algorithm
### BFS
- Queue
- 1. 최소비용
- 2. 간선의 가중치 1
- 3. 정점과 간선의 개수가 적다.(시간 제약, 메모리 제한 내에 만족한다.)

### DFS
- Stack, Recursion

### MST
- Kruskal
- Prim

#### Kruskal
탐욕적인 방법(greedy method) 을 이용하여 네트워크(가중치를 간선에 할당한 그래프)의 모든 정점을 최소 비용으로 연결하는 최적 해답을 구하는 것

#### Prim
시작 정점에서부터 출발하여 신장트리 집합을 단계적으로 확장 해나가는 방법

#### Segment Tree
- 대표값을 트리형태로 저장하는 자료구조
- 각 노드는 자식 노드들을 대표하는 값을 가짐  
![1](https://user-images.githubusercontent.com/32935365/63648002-403e6a00-c764-11e9-87cb-e485ad5d577b.PNG)

#### Lazy Propagation
- 게으르게 업데이트를 전파시켜서 O( logN )만에 Segment Tree에서 구간 업데이트를 달성하는 알고리즘

[출처]  
https://bowbowbow.tistory.com/4  