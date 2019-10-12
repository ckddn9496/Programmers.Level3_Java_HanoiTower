# Programmers.Level3_Java_HanoiTower

## 프로그래머스 > 코딩테스트 연습 > 하노이의 탑

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/12946

input으로 `1`번 기둥에 꼽혀있는 원판의 갯수 `n`이 들어온다. `1`,`2`,`3` 세개의 기둥이 있으며 원판은 하노이의 탑 규칙을 따른다고 한다.

* *하노이의 탑*
> 한 번에 하나의 원판만 옮길 수 있습니다.
> 큰 원판이 작은 원판 위에 있어서는 안됩니다.

이때, `n`개의 원반을 `3`번 기둥으로 최소로 옮기는 방법을 `int[][]`형으로 return하는 문제. 

### 2. 풀이

하노이의 탑에서 `n`개의 원판에 대하여 이동하는 최소 횟수는 `2^n - 1`번이다. `int[Math.pow(2, n) - 1][2]` 배열을 만들고 그 안을 채운 후 return하도록 했다. 하노이의 탑 문제는 재귀적으로 접근하였다. `n`개의 원판을 `1`번 핀에서 `3`번 핀으로 옮기려면 `2`번 핀을 중간 저장소로 두어야한다. 그렇다면 원판 `n`개를 `1`에서`3`으로 옮기는 방법은 `n-1`개를 `1`에서 `2`로 옮긴 후, `n`번째 가장 큰 원반을 `1`에서 `3`으로 옮기고 나머지 `n-1`개의 원판을 `2`에서 `3`으로 옮기는 것이다.

하노이 과정을 출력하는 함수를 `simulateHanoi`라고 명명할 때, 함수의 인자까지 포함하면
`simulateHanoi(int start, int dest, int temp, int n)`로 표현할 수 있다. `start`는 출발지, `dest`는 도착지, `temp`는 임시 저장지, `n`은 옮기려는 원판의 개수이다. 위의 과정을 함수안에 `start, dest, temp`를 적절히 배합하여 구현하였다.

```java
private void simulateHanoi(int start, int dest, int temp, int n) {
  if (n >= 1) {
    simulateHanoi(start, temp, dest, n-1);
    result[idx][0] = start;
    result[idx][1] = dest;
    idx++;
    simulateHanoi(temp, dest, start, n-1);
  }
}
```
