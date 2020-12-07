import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        
        String[][] cube = {
            {"R", "R", "W"},
            {"G", "C", "W"},
            {"G", "B", "B"}
        };
        
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                System.out.print(cube[i][j] + " ");
            } 
            System.out.println();
        }
    }
}