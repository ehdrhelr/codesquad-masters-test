public class Input {
    
    public static String[][] pushTopLeft(String[][] arr) {
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

    public static String[][] pushTopRight(String[][] arr) {
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

    public static String[][] pushRightUp(String[][] arr) {
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

    public static String[][] pushRightDown(String[][] arr) {
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

    public static String[][] pushLeftDown(String[][] arr) {
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

    public static String[][] pushLeftUp(String[][] arr) {
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

    public static String[][] pushBottomRight(String[][] arr) {
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

    public static String[][] pushBottomLeft(String[][] arr) {
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

    public static String[][] getNewCube(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            newArr = searchForEachElement(newArr, arr, i);
        }
        return newArr;
    }

    public static String[][] searchForEachElement(String[][] newArr, String[][] arr, int i) {
        for (int j = 0; j < arr[i].length; j++) {
            if (i == arr.length - 1) {
                newArr[i][getTargetIndexOnLeftPush(arr, i, j)] = arr[i][j];
                continue;
            }
            newArr[i][j] = arr[i][j];
        }
        return newArr;
    }
    
    public static boolean isPushTopLine(int i) {
        return i == 0;
    }

    public static boolean isPushRightLine(String[][] arr, int i, int j) {
        return j == arr[i].length - 1;
    }

    public static boolean isPushLeftLine(int j) {
        return j == 0;
    }

    public static boolean isPushBottomLine(String[][] arr, int i) {
        return i == arr.length - 1;
    }

    public static int getTargetIndexOnLeftPush(String[][] arr, int i, int j) {
        int targetIndex = j - 1;
        if (targetIndex < 0) {
            targetIndex += arr[i].length;
        }
        return targetIndex;
    }

    public static int getTargetIndexOnDownPush(String[][] arr, int i) {
        int targetIndex = i + 1;
        if (targetIndex >= arr.length) {
            targetIndex -= arr.length;
        }
        return targetIndex;
    }

    public static int getTargetIndexOnUpPush(String[][] arr, int i) {
        int targetIndex = i - 1;
        if (targetIndex < 0) {
            targetIndex += arr.length;
        }
        return targetIndex;
    }

    public static int getTargetIndexOnRightPush(String[][] arr, int i, int j) {
        int targetIndex = j + 1;
        if (targetIndex >= arr[i].length) {
            targetIndex -= arr[i].length;
        }
        return targetIndex;
    }
}
