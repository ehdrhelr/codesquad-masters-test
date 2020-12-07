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
        while (true) {
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
        String[] eachCharOfWord = word.split("");
        String[] eachCharOfNewWord = new String[word.length()];
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            eachCharOfNewWord[getTargetIndex(i)] = eachCharOfWord[i];
        }
        for (String eachChar : eachCharOfNewWord) {
            newWord += eachChar;
        }
        return newWord;
    }

    public int getTargetIndex(int currentIndex) {
        if (direction.equalsIgnoreCase("R") && number.startsWith("-")) {
            return pushLeft(currentIndex);
        }
        if (direction.equalsIgnoreCase("L") && number.startsWith("-")) {
            return pushRight(currentIndex);
        }
        if (direction.equalsIgnoreCase("R")) {
            return pushRight(currentIndex);
        }
        if (direction.equalsIgnoreCase("L")) {
            return pushLeft(currentIndex);
        }
        return -1;
    }

    public int pushRight(int currentIndex) {
        int targetIndex = currentIndex + Math.abs(Integer.valueOf(number));
        while (targetIndex >= word.length()) {
            targetIndex -= word.length();
        }
        return targetIndex;
    }

    public int pushLeft(int currentIndex) {
        int targetIndex = currentIndex - Math.abs(Integer.valueOf(number));
        while (targetIndex < 0) {
            targetIndex += word.length();
        }
        return targetIndex;
    }
}