<h3>🔧 구현한 코드</h3>

<h4>Main 클래스</h4>

1. 초기 큐브를 설정하고 출력한다.
    - 밀어낼 방향을 반복을 통해 계속 입력한다.
    - "Q"가 입력되면 반복문을 빠져나오고 "Bye~"출력과 함께 종료된다.
```
public void start(Scanner sc) {
    String[][] cube = {
        {"R", "R", "W"},
        {"G", "C", "W"},
        {"G", "B", "B"}
    };
    printArr2D(cube);
    String input = inputDirection(sc);

    while (!input.equalsIgnoreCase("Q")) {
        cube = pushToDirection(cube, input);
        input = inputDirection(sc);          
    }
    System.out.println("Bye~");
    }
```
2. 밀어낼 방향을 입력하고 그 값을 반환한다.
```
public String inputDirection(Scanner sc) {
    System.out.print("CUBE> ");
    String input = sc.nextLine();
    if (!input.equalsIgnoreCase("Q")){ 
        System.out.println();
    }
    return input;
}
```
3. 방향이 입력되면 그 방향으로 큐브를 밀어낸 후 출력한다.
   - 여러개의 방향이 입력되면 for문을 돌면서 한 방향씩 출력한다.
```
public String[][] pushToDirection(String[][] cube, String input) {
    String direction = "";
    for(int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == '\'') continue;

        direction = input.charAt(i) + "";

        if (i != input.length() - 1 && input.charAt(i + 1) == '\'') {
            direction += "'";    
        }

        cube = printResult(cube, direction);
    }
    return cube;
}
```
4. 입력된 방향에 따라서 Input클래스의 메서드를 호출하여 큐브를 밀어낸다.
   - 밀어낸 큐브를 출력하는 메서드를 호출한다.
```
public String[][] printResult(String[][] cube, String direction) {
    switch(direction) {
        case "U" : cube = Input.pushTopLeft(cube); break;
        case "U'" : cube = Input.pushTopRight(cube); break; 
        case "R" : cube = Input.pushRightUp(cube); break;
        case "R'" : cube = Input.pushRightDown(cube); break;
        case "L" : cube = Input.pushLeftDown(cube); break;
        case "L'" : cube = Input.pushLeftUp(cube); break;
        case "B" : cube = Input.pushBottomRight(cube); break;
        case "B'" : cube = Input.pushBottomLeft(cube); break;
        default : return cube;
    }
    System.out.println(direction);
    printArr2D(cube);
    return cube;
}
```
5. 문자열로된 2차원 배열을 출력하는 메서드.
```  
public void printArr2D(String[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        } 
        System.out.println();
    }
    System.out.println();
}
```

<h4>Input 클래스</h4>

1. 큐브를 해당 방향으로 밀어낸 후 반환한다.
    - 해당 방향으로 밀어낸 라인을 새로운 큐브에 저장한다.
    - 새로운 큐브의 그 외 라인은 기존의 큐브의 요소들을 저장한다.
```
public static String[][] pushTopLeft(String[][] arr) {
    String[][] newArr = new String[3][3];
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            if (isPushTopLine(i)) {
                int target = getTargetIndexOnLeftPush(arr, i, j);
                newArr[i][target] = arr[i][j];
                continue;
            }
            newArr[i][j] = arr[i][j];
        }
    }
    return newArr;
}

public static String[][] pushTopRight(String[][] arr) { ... }
public static String[][] pushRightUp(String[][] arr) { ... }
public static String[][] pushRightDown(String[][] arr) { ... }
public static String[][] pushLeftDown(String[][] arr) { ... }
public static String[][] pushLeftUp(String[][] arr) { ... }
public static String[][] pushBottomRight(String[][] arr) { ... }
public static String[][] pushBottomLeft(String[][] arr) { ... }

```
2. 밀어낼 라인인지 판단한다.
```
public static boolean isPushTopLine(int i) {
    return i == 0;
}

public static boolean isPushRightLine(String[][] arr, int i, int j) {
    return j == arr[i].length - 1;
}

public static boolean isPushLeftLine(int j) {
    return j == 0;
}

public static boolean isPushBottomLine(String[][] arr, int i) {
    return i == arr.length - 1;
}
```

3. 밀어낼 방향에 따라서 기존 큐브 요소들이 이동할 새로운 인덱스를 가져온다.
```
public static int getTargetIndexOnLeftPush(String[][] arr, int i, int j) {
    int targetIndex = j - 1;
    if (targetIndex < 0) {
        targetIndex += arr[i].length;
    }
    return targetIndex;
}

public static int getTargetIndexOnDownPush(String[][] arr, int i) {
    int targetIndex = i + 1;
    if (targetIndex >= arr.length) {
        targetIndex -= arr.length;
    }
    return targetIndex;
}

public static int getTargetIndexOnUpPush(String[][] arr, int i) {
    int targetIndex = i - 1;
    if (targetIndex < 0) {
        targetIndex += arr.length;
    }
    return targetIndex;
}

public static int getTargetIndexOnRightPush(String[][] arr, int i, int j) {
    int targetIndex = j + 1;
    if (targetIndex >= arr[i].length) {
        targetIndex -= arr[i].length;
    }
    return targetIndex;
}
```