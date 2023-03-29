# 히스토그램 프로그램

## 🚀 기능 요구 사항

****

### 추가 기능 요구 사항

- **각 데이터의 양 뿐만 아니라 데이터의 이름, 데이터의 타입을 입력 받는다.**
  - **데이터 타입은 enum으로 제공된다.** 
- **히스토그램을 출력할 때, 데이터 이름, 데이터 타입, 그래프 바를 출력한다.**
- **데이터 양의 평균을 출력한다.**

****

```text
히스토그램은 데이터를 시각적으로 표현한 것이다. 막대로 구성되며 각 막대의 길이는 데이터 양의 크기를 나타낸다. 일부 데이터가 주어지면 히스토그램을 생성하시오.
```
- 데이터의 개수와 데이터 양을 입력받아, 히스토그램으로 표현한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

### 입출력 요구 사항

#### 입력

- 첫 번째 줄에는 데이터의 개수 n을 입력받는다. 이때, 데이터는 음수여서는 안 된다. 
```text
5
```

- 다음 n개의 줄에는 각 데이터의 정보를 입력받는다. 데이터 정보는 데이터 이름, 데이터 양, 데이터 타입이 각각 쉼표로 입력이 되며, 이 때 데이터의 양은 음수여서는 안 된다. 데이터 타입은 숫자로 주어진다.

```
데이터1,1,0
데이터2,3,1
데이터3,4,1
데이터4,6,0
데이터5,2,1
```

#### 출력

- 데이터에 따른 히스토그램을 출력한다.

```
히스토그램 결과입니다.
데이터1(TYPE_0): =
데이터2(TYPE_1): ===
데이터3(TYPE_1): ====
데이터4(TYPE_1): ======
데이터5(TYPE_0): ==
```

- 데이터 양에 대한 평균을 출력한다.

```text
데이터 양에 대한 평균입니다.
평균: 3.2
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 데이터의 개수는 음수일 수 없습니다.
```

#### 실행 결과 예시

```
데이터의 개수를 입력해주세요.
5

각 데이터의 양을 입력해주세요
데이터1,1,0
데이터2,3,1
데이터3,4,1
데이터4,6,0
데이터5,2,1

히스토그램 결과입니다.
데이터1(TYPE_0): =
데이터2(TYPE_1): ===
데이터3(TYPE_1): ====
데이터4(TYPE_1): ======
데이터5(TYPE_0): ==

데이터 양에 대한 평균입니다.
평균: 3.2
```

## 🎯 프로그램 요구 사항

****

### 프로그램 추가 요구 사항

- **현재 gradle 의존성에 테스트를 위한 라이브러리인 Junit, Assertj 가 추가되어 있다. 이를 이용해서 입,출력을 제외한 테스트 코드를 작성한다.**

****

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Array를 사용하지 않는다. Array가 필요한 경우 List를 사용한다.
- 하나의 클래스에는 하나의 역할만 가지도록 한다.
- 추후에 입력되는 데이터가 달라질 수 있다는 점을 유의해서 구현하면 좋다.

## 과제 제출 방법

- `fork`를 하지 않은 경우 `fork`를 한다. `fork`를 한 경우 `main` 브랜치를 `fork` 한 repository의 main에 merge 한다.
- `fork` 한 브랜치에서는 본인이 각 과제를 구분할 수 있는 브랜치를 만든다. (이전 과제와 같은 브랜치에서 진행하면 안 된다)
- 원본 repository에 본인 github 아이디에 해당하는 브랜치를 만들고, 구현이 완료되면 원본 저장소의 본인 브랜치에 `Pull Requeset`를 보낸다.    