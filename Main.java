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
        switch(direction) {
            case "U" : printArr2D(inputU(cube)); break;
        }
    }

    public String inputDirection(Scanner sc) {
        System.out.print("CUBE> ");
        return sc.nextLine();
    }

    public void printArr2D(Object[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            } 
            System.out.println();
        }
        System.out.println();
    }

    public Object[][] inputU(Object[][] arr) {
        Object[][] newArr = new Object[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    int targetIndex = j - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr[0].length;
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