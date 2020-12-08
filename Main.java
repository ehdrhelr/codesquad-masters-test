import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.start(sc);
        
    }

    public void start(Scanner sc) {
        String[][][] cube = getInitialCube();
        Printer.printCube(cube);
        Rotation rot = new Rotation();
        while (true) {
            System.out.print("CUBE> ");
            String input = sc.nextLine();
            getTargetDimensionsInInput(cube, input, rot);
        }
    }

    public void getTargetDimensionsInInput(String[][][] cube, String input, Rotation rot) {
        String target = "";
        for (int i = 0; i < input.length(); i++) {
            target = input.charAt(i) + "";
            int targetDimension = inputTargetDimension(target);
            if (targetDimension == -1) continue;
            cube = rot.rotateClockwise(cube, targetDimension);
            Printer.printCube(cube);
        }
    }

    public int inputTargetDimension(String rotation) {
        System.out.println();
        int targetDimension = -1;
        switch(rotation) {
            case "U" : targetDimension = 0; break;
            case "L" : targetDimension = 1; break;
            case "F" : targetDimension = 2; break;
            case "R" : targetDimension = 3; break;
            case "B" : targetDimension = 4; break;
            case "D" : targetDimension = 5; break;
        }
        if (0 <= targetDimension && targetDimension <= 5) {
            System.out.println(rotation);
        }
        return targetDimension;
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