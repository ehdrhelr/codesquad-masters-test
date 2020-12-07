import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.start(sc);
    }

    public void start(Scanner sc) {
        String[][] cube = {
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
        };
        printArr2D(cube);
        String direction = inputDirection(sc);
        while (!direction.equalsIgnoreCase("Q")) {
            switch(direction) {
                case "U" : cube = inputUL(cube); break;
                case "U'" : cube = inputUR(cube); break; 
                case "R" : cube = inputRU(cube); break;
                case "R'" : cube = inputRD(cube); break;
                case "L" : cube = inputLD(cube); break;
                case "L'" : cube = inputLU(cube); break;
                case "B" : cube = inputBR(cube); break;
                case "B'" : cube = inputBL(cube); break;
            }
            printArr2D(cube);
            direction = inputDirection(sc);
        }
        System.out.println("Bye~");
    }

    public String inputDirection(Scanner sc) {
        System.out.print("CUBE> ");
        return sc.nextLine();
    }

    public void printArr2D(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            } 
            System.out.println();
        }
        System.out.println();
    }

    public String[][] inputUL(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    int targetIndex = j - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputUR(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    int targetIndex = j + 1;
                    if (targetIndex >= arr[i].length) {
                        targetIndex -= arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputRU(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    int targetIndex = i - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputRD(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    int targetIndex = i + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputLD(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    int targetIndex = i + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputLU(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    int targetIndex = i - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputBR(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1) {
                    int targetIndex = j + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public String[][] inputBL(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1) {
                    int targetIndex = j - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }  
}