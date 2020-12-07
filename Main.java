import java.util.*;

public class Main {

    String word = "";
    String number = "";
    String direction = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Main main = new Main();
        main.inputWordNumberDirection(sc);
    }

    public void inputWordNumberDirection(Scanner sc) {
        String input = sc.nextLine();
        String[] WordNumberDirection = input.split(" ");
        word = WordNumberDirection[0];
        number = WordNumberDirection[1];
        direction = WordNumberDirection[2];
    }


}