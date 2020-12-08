import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.getInitialCube();
    }

    public void getInitialCube() {
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
        Printer.printCube(cube);
    }
}