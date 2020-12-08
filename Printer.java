public class Printer {

    public static void print2DArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            printLongBlank(i);
            for (int j = 0; j < arr[i].length; j++) {
                printBlankBetweenDimensionsInMid(i, j);
                System.out.printf("%s ", arr[i][j]);
            }            
            printBlankBetweenTopBottomAndMid(i);
            System.out.println();
        }
    }

    public static void printLongBlank(int i) {
        if (i < 3 || 5 < i) {
            System.out.printf("%15s", " ");
        }
    }
    
    public static void printBlankBetweenTopBottomAndMid(int i) {
        if (i == 2 || i == 5) {
            System.out.println();
        }
    }

    public static void printBlankBetweenDimensionsInMid(int i, int j) {
        if ((3 <= i && i <= 5) && (j % 3 == 0 && j != 0)) {
            System.out.printf("%4s", " ");
        }
    }
}
