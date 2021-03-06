# Simpletron 
### 프로젝트 개요
> <b>SML(Simpletron Machine Language) 로 작동되는 기계어 프로그램</b>을 만드는 코딩 과제입니다.</br>
> 컴퓨터를 "완전히 열고" 내부 구조를 살펴봤습니다.

</br>

### 프로젝트 설명
> Simpletron의 모든 정보는 word로 다루어집니다.<br>  
<b>연산 명령은 4개의 십진수</b>로 나타내고, 명령이 저장될 <b>메모리 수는 00~99 까지 총 100개</b> 입니다.<br>  
메모리 내에는 명령, 프로그램에 의해 사용된 데이터 값, 메모리에 사용되지 않은 빈 영역입니다.<br>  
SML 프로그램을 실행하기 전에 메모리에 프로그램에게 내릴 명령들을 메모리에 저장해야 합니다.<br>      
각 SML 명령의 첫 번째에 위치한 두 개의 숫자는 <b>연산 코드(operation code)</b> 이고, 두 번째에 위치한 두 개의 숫자는 연산 코드가 저장 될 <b>메모리 위치(operand)</b> 입니다.

<br>

+ SML 의 연산 코드 표

<img width="50%" src="https://user-images.githubusercontent.com/46162801/144183640-17a4842c-4358-4249-91d6-7e15f24b0e1c.PNG">

</br>

#### 문제 1 - 감시 제어 반복 (while)
1. 10개의 양의 수를 읽기 위해 감시 제어 반복을 사용하여 합을 계산하고 출력하라.

+ 답안

<img width="40%" src="https://user-images.githubusercontent.com/46162801/144181983-a2401275-34d1-4574-8677-669498576704.PNG">

</br>
</br>

+ 실행 후 cmd 출력 창 모습

<img width="40%" src="https://user-images.githubusercontent.com/46162801/144182430-e85278c7-b4a7-41f9-b5fd-695e671cdc5a.png">


#### 문제 2 - 카운터 제어 반복 (for)
2. 7개 수, 양수, 음수를 읽기 위해 카운터 제어 반복을 사용하고 평균을 계산하고 출력하라.

+ 답안

<img width="40%" src="https://user-images.githubusercontent.com/46162801/144182018-475dade2-2556-47a4-a3e9-375a8629ba6c.PNG">

#### 문제 3
3. 일련의 수를 읽고 가장 큰 수를 결정하고 출력하라. 첫 번째 수는 얼마나 많은 수가 처리 되었는 지 나타내는 것을 읽는다.

+ 답안

<img width="40%" src="https://user-images.githubusercontent.com/46162801/144182046-d36f1ab6-4527-40d9-b689-9ec6d5c08202.PNG">

