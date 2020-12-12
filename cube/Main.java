package cube;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    int rotationCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.start(sc);
    }

    public void start(Scanner sc) {
        String[][][] cube = getInitialCube();
        Printer.printCube(cube);
        Rotation rotation = new Rotation();
        String input = "";
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
        }
        long endTime = System.currentTimeMillis();        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        String time = simpleDateFormat.format(endTime - startTime);
        printResult(time);
    }

    public void printResult(String time) {
        System.out.println("경과시간: " + time);
        System.out.println("조작갯수: " + rotationCount);
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }

    public String[][][] getNewCube(String[][][] cube, String input, Rotation rotation) {
        for (int i = 0; i < input.length(); i++) {
            String target = input.charAt(i) + "";
            if ((i != input.length() - 1) && (input.charAt(i + 1) + "").equals("'")) {
                target += "'";
                i++;
            }
            int targetDimension = inputTargetDimension(target);
            if (targetDimension == -1) continue;
            cube = getCube(target, cube, rotation, targetDimension);
            Printer.printCube(cube);
            
            if ((i != input.length() - 1) && input.charAt(i + 1) == '2') {
                System.out.println(target);
                cube = getCube(target, cube, rotation, targetDimension);
                Printer.printCube(cube);
            }
        }
        return cube;
    }

    public int inputTargetDimension(String direction) {
        int targetDimension = getTargetDimensionByInput(direction);
        if (0 <= targetDimension && targetDimension <= 5) {
            System.out.println(direction);
            rotationCount++;
        }
        return targetDimension;
    }

    public static String[][][] getCube(
                String target, String[][][] cube, Rotation rotation, int targetDimension) {        
        if (target.endsWith("'")) {
            cube = rotation.rotateCounterClockwise(cube, targetDimension);
        } else {
            cube = rotation.rotateClockwise(cube, targetDimension);
        }
        return cube;
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

    public String[][][] getInitialCube() {
        String[][][] cube = {
            {   { "B", "B", "B" },      // 초기 up, index 0
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
                { "R", "R", "R" }   }
        };
        return cube;
    }
}