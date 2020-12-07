<h3>🔧 구현한 코드</h3>

1. 사용자로부터 단어, 숫자, 방향을 입력받는다.
    - 띄어쓰기를 기준으로 나눈 후 배열에 저장한다.
    - 각 배열에 저장된 데이터를 각각 멤버변수 word, number, direction에 저장한다.
```
public void inputWordNumberDirection(Scanner sc) {
    System.out.print("> ");
    String input = sc.nextLine();
    String[] WordNumberDirection = input.split(" ");
    word = WordNumberDirection[0];
    number = WordNumberDirection[1];
    direction = WordNumberDirection[2];
}
```
2. 입력된 number와 direction에 따라 word를 어느방향으로 얼만큼 밀어낼지 정한다.
    - direction이 'R'이면 오른쪽으로 number만큼 밀어낸다.
    - direction이 'L'이면 왼쪽으로 number만큼 밀어낸다.
    - number가 음수이면 입력된 direction과 반대반향으로 밀어낸다.
```
public String moveChar() {
    if (direction.equalsIgnoreCase("R") && number.startsWith("-")) {
        return moveCharToLeft();
    }
    if (direction.equalsIgnoreCase("L") && number.startsWith("-")) {
        return moveCharToRight();
    }
    if (direction.equalsIgnoreCase("R")) {
        return moveCharToRight();
    }
    if (direction.equalsIgnoreCase("L")) {
        return moveCharToLeft();
    }
    return "";
}
```
3. 입력된 word의 각 문자를 배열에 담고, 밀려난 word의 각 문자를 담을 배열을 생성한다.
   - direction(왼쪽 또는 오른쪽)으로 number만큼 밀려난 위치를 target index로 삼는다.
   - word 각 문자를 저장한 배열의 index를 돌면서 새로 밀려날 위치 target index를 확인 후 해당 index의 데이터를 newWord의 각 문자를 저장할 배열의 target index에 저장한다.
```
public String moveCharToRight() {
    String[] eachCharOfWord = word.split("");
    String[] eachCharOfNewWord = new String[word.length()];
    String newWord = "";
    for (int i = 0; i < word.length(); i++) {
        eachCharOfNewWord[getTargetIndexRight(i)] = eachCharOfWord[i];
    }
    for (String eachChar : eachCharOfNewWord) {
        newWord += eachChar;
    }
    return newWord;
}
```
4. target index는 오른쪽으로 이동 시, 현재 index에서 number만큼 더한 값이다.
    - target index가 word의 길이를 초과할 경우, 반대쪽으로 채우기 위해 word의 길이만큼 빼준다.
    - 왼쪽으로 이동 시에는 그 반대다.
```
public int getTargetIndexRight(int currentIndex) {
    int targetIndex = currentIndex + Math.abs(Integer.valueOf(number));
    while (targetIndex >= word.length()) {
        targetIndex -= word.length();
    }
    return targetIndex;
}

public int getTargetIndexLeft(int currentIndex) {
    int targetIndex = currentIndex - Math.abs(Integer.valueOf(number));
    while (targetIndex < 0) {
        targetIndex += word.length();
    }
    return targetIndex;
}
```