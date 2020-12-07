import java.util.*;

public class Main {

    String word = "";
    String number = "";
    String direction = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Main main = new Main();
        main.inputWordNumberDirection(sc);
        //main.moveCharToRight();
        main.moveCharToLeft();
    }

    public void inputWordNumberDirection(Scanner sc) {
        System.out.print("> ");
        String input = sc.nextLine();
        String[] WordNumberDirection = input.split(" ");
        word = WordNumberDirection[0];
        number = WordNumberDirection[1];
        direction = WordNumberDirection[2];
    }

    public void moveCharToRight() {
        String[] eachCharOfWord = word.split("");
        String[] newWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int targetIndex = getTargetIndex(i);
            newWord[targetIndex] = eachCharOfWord[i];
        }
        for (String str : newWord) {
            System.out.print(str);
        }
    }

    public int getTargetIndex(int currentIndex) {
        int targetIndex = currentIndex + Integer.valueOf(number);
        if (targetIndex >= word.length()) {
            targetIndex -= word.length();
        }
        return targetIndex;
    }

    public void moveCharToLeft() {
        String[] eachCharOfWord = word.split("");
        String[] newWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int targetIndex = getTargetIndexLeft(i);
            newWord[targetIndex] = eachCharOfWord[i];
        }
        for (String str : newWord) {
            System.out.print(str);
        }
    }

    public int getTargetIndexLeft(int currentIndex) {
        int targetIndex = currentIndex - Integer.valueOf(number);
        if (targetIndex < 0) {
            targetIndex += word.length();
        }
        return targetIndex;
    }
}