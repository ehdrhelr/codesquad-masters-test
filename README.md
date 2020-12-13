<h3>🔧 구현한 코드</h3>

<h4>Main 클래스</h4>
- Main 클래스에 멤버변수를 아래와 같이 선언한다.
  
        int rotationCount = 0;
        String[][][] cube;
        SimpleDateFormat simpleDateFormat;

- 생성자를 통해 3차원배열 cube에 초기값을 설정한다.

        Main() {
            cube = getInitialCube();
            simpleDateFormat = new SimpleDateFormat("mm:ss");
        }

        public String[][][] getInitialCube() {
        String[][][] cube = {   {   { "B", "B", "B" },      // 초기 up, index 0
                                    { "B", "B", "B" },
                                    { "B", "B", "B" }   },
                                {   { "W", "W", "W" },      // 초기 left, index 1
                                    { "W", "W", "W" },
                                    { "W", "W", "W" }   },
                                {   { "O", "O", "O" },      // 초기 front, index 2
                                    { "O", "O", "O" },
                                    { "O", "O", "O" }   },    
                                {   { "G", "G", "G" },      // 초기 right, index 3
                                    { "G", "G", "G" },
                                    { "G", "G", "G" }   },
                                {   { "Y", "Y", "Y" },      // 초기 back, index 4
                                    { "Y", "Y", "Y" },
                                    { "Y", "Y", "Y" }   },
                                {   { "R", "R", "R" },      // 초기 down, index 5
                                    { "R", "R", "R" },
                                    { "R", "R", "R" }   }   };
        return cube;
    }

- 초기 큐브를 출력한다.
- 큐브를 돌릴 방향을 입력받는다.
- 'shuffle'을 입력하면 큐브를 무작위로 섞는다.
- 조작된 큐브가 초기 큐브와 일치하면 축하메세지를 출력하고 프로그램을 종료한다.
- 'q'가 입력되면 프로그램을 종료한다.
- 종료시 경과 시간과 조작 횟수를 출력한다.

        public void start(Scanner sc) {
            String input = "";
            Printer.printCube(cube);
            long startTime = System.currentTimeMillis();
            while (!input.equalsIgnoreCase("q")) {
                System.out.print("CUBE> ");
                input = sc.nextLine();
                System.out.println();
                if (input.equals("shuffle")) {
                    Shuffle.start(cube, rotation);
                    continue;
                }
                cube = getNewCube(cube, input, rotation);
                if (!input.equalsIgnoreCase("q") && Arrays.deepEquals(cube, getInitialCube())) {
                    System.out.println("< < < 축하합니다. 모두 맞히셨습니다!!! > > >");
                    break;
                }
            }
            long endTime = System.currentTimeMillis();        
            
            String time = simpleDateFormat.format(endTime - startTime);
            printResult(time);
        }

- 방향이 입력될 때마다 새로운 큐브를 가져온다.
- 입력된 방향 갯수만큼 회전을 진행한다.
- 잘못된 입력은 무시한다.
- 현재 방향의 뒷 문자가 '2'면 한번 더 회전한다. 

        public String[][][] getNewCube(String[][][] cube, String input) {
            for (int i = 0; i < input.length(); i++) {
                String target = input.charAt(i) + "";
                if ((i != input.length() - 1) && (input.charAt(i + 1) + "").equals("'")) {
                    target += "'";
                    i++;
                }
                int targetDimension = inputTargetDimension(target);
                if (targetDimension == -1) continue;
                cube = getCube(target, cube, targetDimension);
                Printer.printCube(cube);

                if ((i != input.length() - 1) && input.charAt(i + 1) == '2') {
                    System.out.println(target);
                    cube = getCube(target, cube, targetDimension);
                    Printer.printCube(cube);
                }
            }
            return cube;
        }

- 방향이 입력되면 해당하는 숫자를 반환한다.
- 올바른 방향이 입력되면 방향을 출력하고 조작횟수를 1 증가시킨다.

        public int inputTargetDimension(String direction) {
            int targetDimension = getTargetDimensionByInput(direction);
            if (0 <= targetDimension && targetDimension <= 5) {
                System.out.println(direction);
                rotationCount++;
            }
            return targetDimension;
        }

        public int getTargetDimensionByInput(String direction) {
            switch(direction) {
                case "U" : case "U'" : return 0;
                case "L" : case "L'" : return 1;
                case "F" : case "F'" : return 2;
                case "R" : case "R'" : return 3;
                case "B" : case "B'" : return 4;
                case "D" : case "D'" : return 5;
            }
            return -1;
        }

- 현재 방향의 뒷 문자가 " ' " 라면 반시계방향, 아니라면 시계방향으로 회전한다.

        public String[][][] getCube(
                    String target, String[][][] cube, int targetDimension) {        
            if (target.endsWith("'")) {
                cube = Rotation.rotateCounterClockwise(cube, targetDimension);
            } else {
                cube = Rotation.rotateClockwise(cube, targetDimension);
            }
            return cube;
        }

<h4>Rotation 클래스</h4>

- 입력된 방향에 따라서 시계방향, 반시계반향으로 회전한 큐브를 반환한다.
- 먼저 기준 면을 회전시키고 newCube에 담는다.
- 다음 기준 면과 붙어 있는 면의 요소들을 회전시키고 newCube에 담는다.

        public static String[][][] rotateClockwise(String[][][] cube, int targetDimension) {
            String[][][] newCube = new String[6][3][3];
            newCube = Clockwise.rotateTargetDimension(newCube, cube, targetDimension);
            newCube = Clockwise.rotateOtherDimensions(newCube, cube, targetDimension);
            return newCube;
        }

        public static String[][][] rotateCounterClockwise(String[][][] cube, int targetDimension) {
            String[][][] newCube = new String[6][3][3];
            newCube = CounterClockwise.rotateTargetDimension(newCube, cube, targetDimension);
            newCube = CounterClockwise.rotateOtherDimensions(newCube, cube, targetDimension);
            return newCube;
        }

<h4>Clockwise, CounterClockwise 클래스</h4>

- 기준면의 위, 아래, 오른쪽, 왼쪽 요소들에 회전시킬 위치 값을 지정한 후, newCube의 그 위치에 저장한다.
- 가운데 값은 그대로 newCube에 입력한다.
- 기준면을 제외한 나머지 면들의 값들도 그대로 입력한다.

        public static String[][][] rotateTargetDimension(
                        String[][][] newCube, String[][][] cube, int targetDimension) {
            newCube = rotateTopToRight(newCube, cube, targetDimension);
            newCube = rotateRightToBottom(newCube, cube, targetDimension);
            newCube = rotateBottomToLeft(newCube, cube, targetDimension);
            newCube = rotateLeftToTop(newCube, cube, targetDimension);
            newCube[targetDimension][1][1] = cube[targetDimension][1][1];
            newCube = inputOldDataExceptTargetDimension(newCube, cube, targetDimension);
            return newCube;
        }

        public static String[][][] rotateTargetDimension(
                        String[][][] newCube, String[][][] cube, int targetDimension) {
            newCube = rotateTopToLeft(newCube, cube, targetDimension);
            newCube = rotateRightToTop(newCube, cube, targetDimension);
            newCube = rotateBottomToRight(newCube, cube, targetDimension);
            newCube = rotateLeftToBottom(newCube, cube, targetDimension);
            newCube[targetDimension][1][1] = cube[targetDimension][1][1];
            newCube = inputOldDataExceptTargetDimension(newCube, cube, targetDimension);
            return newCube;
        }

- 기존 큐브의 요소들을 회전시킨 새로운 위치에 담는 메서드

        public static String[][][] rotateTopToRight(
                        String[][][] newCube, String[][][] cube, int targetDimension) {
            for (int i = 0; i < cube[targetDimension].length; i++) {
                newCube[targetDimension][i][2] = cube[targetDimension][0][i];
            }
            return newCube;
        }

        public static String[][][] rotateRightToBottom(String[][][] newCube, String[][][] cube, int targetDimension) { ... }
        
        public static String[][][] rotateBottomToLeft(String[][][] newCube, String[][][] cube, int targetDimension) { ... }

        ... 

- 기준 면을 제외한 면들의 요소들을 새로운 큐브에 담는 메서드

        public static String[][][] inputOldDataExceptTargetDimension(
                        String[][][] newCube, String[][][] cube, int targetDimension) {
            for (int i = 0; i < cube.length; i++) {
                if (i == targetDimension) continue;
                for (int j = 0; j < cube[i].length; j++) {
                    newCube = inputElements(newCube, cube, i, j);
                }
            }
            return newCube;
        }

        public static String[][][] inputElements(String[][][] newCube, String[][][] cube, int i, int j) {
            for (int k = 0; k < cube[i][j].length; k++) {
                newCube[i][j][k] = cube[i][j][k];
            }
            return newCube;
        }

- 입력된 기준 면에 접한 면들의 요소들을 회전시키기 위해 메서드를 찾아간다.

        public static String[][][] rotateOtherDimensions(
                        String[][][] newCube, String[][][] cube, int targetDimension) {
            if (targetDimension == 0) {
                return rotateSideDimensionsOfUp(newCube, cube);
            }
            if (targetDimension == 1) {
                return rotateSideDimensionsOfLeft(newCube, cube);
            }
            if (targetDimension == 2) {
                return rotateSideDimensionsOfFront(newCube, cube);
            }
            if (targetDimension == 3) {
                return rotateSideDimensionsOfRight(newCube, cube);
            }
            if (targetDimension == 4) {
                return rotateSideDimensionsOfBack(newCube, cube);
            }
            if (targetDimension == 5) {
                return rotateSideDimensionsOfDown(newCube, cube);
            }
            return newCube;
        }

- 접한 면들의 요소들을 회전시킨 새로운 위치에 대입한다.

        public static String[][][] rotateSideDimensionsOfUp(String[][][] newCube, String[][][] cube) {
            for (int i = 1; i < cube.length - 1; i++) {
                for (int j = 0; j < cube[i][0].length; j++) {
                    newCube[getTargetIndexOfSideDimensionsOfUp(i)][0][j] = cube[i][0][j];
                }
            }
            return newCube;
        }

        public static int getTargetIndexOfSideDimensionsOfUp(int i) {
            int targetFirstIndex = i - 1;
            if (targetFirstIndex < 1) {
                targetFirstIndex = 4;
            }
            return targetFirstIndex;
        }

        public static String[][][] rotateSideDimensionsOfLeft(String[][][] newCube, String[][][] cube) { ... }

        public static String[][][] rotateSideDimensionsOfFront(String[][][] newCube, String[][][] cube) { ... }

        ...

<h4>Shuffle 클래스</h4>

- 'shuffle'이 입력되었을 경우를 확인하기 위한 상수를 가진다.

        public static final int INPUT = -2;

- 유효한 입력값들의 배열을 가진다.

        public static String[] directions = {"U", "U'", "L", "L'", "F", "F'", "R", "R'", "B", "B'", "D", "D'"};

- 배열의 인덱스를 무작위로 추출하여 회전시킬 방향을 입력하고 새로운 큐브를 얻는다.
- 100회 반복한다.

        public static void start(String[][][] cube) {
            Main main = new Main();
            for (int i = 0; i < 100; i++) {
                int randomIndex = (int) (Math.random() * directions.length);
                String direction = directions[randomIndex];
                int targetDimension = main.getTargetDimensionByInput(direction);
                cube = getCube(direction, cube, targetDimension);
            }
            Printer.printCube(cube);
        }

        public static String[][][] getCube(
                    String target, String[][][] cube, int targetDimension) {
            if (target.endsWith("'")) {
                cube = Rotation.rotateCounterClockwise(cube, targetDimension);
            } else {
                cube = Rotation.rotateClockwise(cube, targetDimension);
            }
            return cube;
        }

<h4>Printer 클래스</h4>

- 큐브를 위, 중간, 아래를 기준으로 하나씩 출력한다.

        public static void printCube(String[][][] cube) {
            printUp(cube);
            printMid(cube);
            printDown(cube);
            System.out.println();
        }