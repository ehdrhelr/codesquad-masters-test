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
        String input = inputDirection(sc);
        
        while (!input.equalsIgnoreCase("Q")) {
            cube = pushToDirection(cube, input);
            input = inputDirection(sc);          
        }
        System.out.println("Bye~");
    }

    public String inputDirection(Scanner sc) {
        System.out.print("CUBE> ");
        String input = sc.nextLine();
        if (!input.equalsIgnoreCase("Q")){ 
            System.out.println();
        }
        return input;
    }

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

    public void printArr2D(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            } 
            System.out.println();
        }
        System.out.println();
    }
}