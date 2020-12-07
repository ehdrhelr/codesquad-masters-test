import java.util.*;

public class Main {

    String word = "";
    String number = "";
    String direction = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        main.start(sc);
    }

    public void start(Scanner sc) {
        while (!word.equals("q")) {
            inputWordNumberDirection(sc);
            System.out.println(moveChar());
        }
    }

    public void inputWordNumberDirection(Scanner sc) {
        System.out.print("> ");
        String input = sc.nextLine();
        String[] WordNumberDirection = input.split(" ");
        word = WordNumberDirection[0];
        number = WordNumberDirection[1];
        direction = WordNumberDirection[2];
    }

    public String moveChar() {
        if (direction.equalsIgnoreCase("R") && number.startsWith("-")) {
            return moveCharToLeft();
        }
        if (direction.equalsIgnoreCase("L") && number.startsWith("-")) {
            return moveCharToRight();
        }
        if (direction.equalsIgnoreCase("R")) {
            return moveCharToRight();
        }
        if (direction.equalsIgnoreCase("L")) {
            return moveCharToLeft();
        }
        return "";
    }

    public String moveCharToRight() {
        String[] eachCharOfWord = word.split("");
        String[] eachCharOfNewWord = new String[word.length()];
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            eachCharOfNewWord[getTargetIndexRight(i)] = eachCharOfWord[i];
        }
        for (String eachChar : eachCharOfNewWord) {
            newWord += eachChar;
        }
        return newWord;
    }

    public int getTargetIndexRight(int currentIndex) {
        int targetIndex = currentIndex + Math.abs(Integer.valueOf(number));
        if (targetIndex >= word.length()) {
            targetIndex -= word.length();
        }
        return targetIndex;
    }

    public String moveCharToLeft() {
        String[] eachCharOfWord = word.split("");
        String[] eachCharOfNewWord = new String[word.length()];
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            eachCharOfNewWord[getTargetIndexLeft(i)] = eachCharOfWord[i];
        }
        for (String eachChar : eachCharOfNewWord) {
            newWord += eachChar;
        }
        return newWord;
    }

    public int getTargetIndexLeft(int currentIndex) {
        int targetIndex = currentIndex - Math.abs(Integer.valueOf(number));
        if (targetIndex < 0) {
            targetIndex += word.length();
        }
        return targetIndex;
    }
}