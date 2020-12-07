public class Input {
    
    public static String[][] moveTopLeft(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    int targetIndex = j - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveTopRight(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    int targetIndex = j + 1;
                    if (targetIndex >= arr[i].length) {
                        targetIndex -= arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveRightUp(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    int targetIndex = i - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveRightDown(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    int targetIndex = i + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveLeftDown(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    int targetIndex = i + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveLeftUp(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    int targetIndex = i - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr.length;
                    }
                    newArr[targetIndex][j] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveBottomRight(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1) {
                    int targetIndex = j + 1;
                    if (targetIndex >= arr.length) {
                        targetIndex -= arr.length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    public static String[][] moveBottomLeft(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1) {
                    int targetIndex = j - 1;
                    if (targetIndex < 0) {
                        targetIndex += arr[i].length;
                    }
                    newArr[i][targetIndex] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }  
}
