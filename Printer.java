public class Printer {

    public static void printCube(String[][][] cube) {
        printUp(cube);
        printMid(cube);
        printDown(cube);
        System.out.println();
    }

    public static void printUp(String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            System.out.printf("%15s", " ");
            for (int j = 0; j < cube[0][i].length; j++) {
                System.out.printf("%s ", cube[0][i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMid(String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            for (int j = 1; j < cube.length - 1; j++) {
                printMidElements(cube, i, j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMidElements(String[][][] cube, int i, int j) {
        for (int k = 0; k < cube[j][i].length; k++) {
            System.out.printf("%s ", cube[j][i][k]);
        }
        if (i != cube.length - 2) {
            System.out.printf("%4s", " ");
        }
    }

    public static void printDown(String[][][] cube) {
        for (int i = 0; i < cube[5].length; i++) {
            System.out.printf("%15s", " ");
            for (int j = 0; j < cube[5][i].length; j++) {
                System.out.printf("%s ", cube[5][i][j]);
            }
            System.out.println();
        }
    }
}