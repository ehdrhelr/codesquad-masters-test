import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.getInitialCube();
    }

    public void getInitialCube() {
        String[][] cube = {
                                {"B", "B", "B"},
                                {"B", "B", "B"},
                                {"B", "B", "B"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},      
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
            {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y", "Y", "Y"},
                                {"R", "R", "R"},
                                {"R", "R", "R"},
                                {"R", "R", "R"}
        };
        Printer.print2DArr(cube);
    }

    

    
}