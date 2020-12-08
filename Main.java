import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        String[][][] cube = main.getInitialCube();
        Rotation rotation = new Rotation();
        cube = rotation.rotateClockwise(cube, 1);
        Printer.printCube(cube);
        cube = rotation.rotateClockwise(cube, 2);
        Printer.printCube(cube);

    }

    public String[][][] getInitialCube() {
        String[][][] cube = {
            {   { "1", "2", "3" },      // 초기 up, index 0
                { "4", "5", "6" },
                { "7", "8", "9" }   },
            {   { "A", "B", "C" },      // 초기 left, index 1
                { "D", "E", "F" },
                { "G", "H", "I" }   },
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
        Printer.printCube(cube);
        return cube;
    }
}