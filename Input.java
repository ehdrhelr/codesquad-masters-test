public class Input {
    
    public static String[][] pushTopLeft(String[][] arr) {
        String[][] newArr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPushTopLine(i)) {
                    int target = getTargetIndexOnLeftPush(arr, i, j);
                    newArr[i][target] = arr[i][j];
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
                if (isPushTopLine(i)) {
                    int target = getTargetIndexOnRightPush(arr, i, j);
                    newArr[i][target] = arr[i][j];
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
                if (isPushRightLine(arr, i, j)) {
                    int target = getTargetIndexOnUpPush(arr, i);
                    newArr[target][j] = arr[i][j];
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
                if (isPushRightLine(arr, i, j)) {
                    int target = getTargetIndexOnDownPush(arr, i);
                    newArr[target][j] = arr[i][j];
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
                if (isPushLeftLine(j)) {
                    int target = getTargetIndexOnDownPush(arr, i);
                    newArr[target][j] = arr[i][j];
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
                    int target = getTargetIndexOnUpPush(arr, i);
                    newArr[target][j] = arr[i][j];
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
                if (isPushBottomLine(arr, i)) {
                    int target = getTargetIndexOnRightPush(arr, i, j);
                    newArr[i][target] = arr[i][j];
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
                if (isPushBottomLine(arr, i)) {
                    int target = getTargetIndexOnLeftPush(arr, i, j);
                    newArr[i][target] = arr[i][j];
                    continue;
                }
                newArr[i][j] = arr[i][j];
            }
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
