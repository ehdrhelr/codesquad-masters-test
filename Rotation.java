public class Rotation {

    public String[][][] rotateClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = rotateTargetDimension(newCube, cube, targetDimension);
        newCube = rotateOtherDimensions(newCube, cube, targetDimension);
        return newCube;
    }

    public String[][][] rotateTargetDimension(
                            String[][][] newCube, String[][][] cube, int targetDimension) {
        newCube = rotateTopToRight(newCube, cube, targetDimension);
        newCube = rotateRightToBottom(newCube, cube, targetDimension);
        newCube = rotateBottomToLeft(newCube, cube, targetDimension);
        newCube = rotateLeftToTop(newCube, cube, targetDimension);
        newCube[targetDimension][1][1] = cube[targetDimension][1][1];
        newCube = inputOldDataExceptTargetDimension(newCube, cube, targetDimension);
        return newCube;
    }

    public String[][][] rotateTopToRight(
                                String[][][] newCube, String[][][] cube, int targetDimension) {
        for (int i = 0; i < cube[targetDimension].length; i++) {
            newCube[targetDimension][i][2] = cube[targetDimension][0][i];
        }
        return newCube;
    }

    public String[][][] rotateRightToBottom(
                                String[][][] newCube, String[][][] cube, int targetDimension) {
        for (int i = 0; i < cube[targetDimension].length; i++) {
            newCube[targetDimension][2][cube[targetDimension].length - i - 1]
            = cube[targetDimension][i][2];
        }
        return newCube;
    }

    public String[][][] rotateBottomToLeft(
                                String[][][] newCube, String[][][] cube, int targetDimension) {
        for (int i = 0; i < cube[targetDimension].length; i++) {
            newCube[targetDimension][i][0] = cube[targetDimension][2][i];
        }
        return newCube;
    }

    public String[][][] rotateLeftToTop(
                                String[][][] newCube, String[][][] cube, int targetDimension) {
        for (int i = 0; i < cube[targetDimension].length; i++) {
            newCube[targetDimension][0][cube[targetDimension].length - i - 1]
            = cube[targetDimension][i][0];
        }
        return newCube;
    }

    public String[][][] inputOldDataExceptTargetDimension(
                                    String[][][] newCube, String[][][] cube, int targetDimension) {
        for (int i = 0; i < cube.length; i++) {
            if (i == targetDimension) continue;
            for (int j = 0; j < cube[i].length; j++) {
                newCube = inputElements(newCube, cube, i, j);
            }
        }
        return newCube;
    }

    public String[][][] inputElements(String[][][] newCube, String[][][] cube, int i, int j) {
        for (int k = 0; k < cube[i][j].length; k++) {
            newCube[i][j][k] = cube[i][j][k];
        }
        return newCube;
    }

    public String[][][] rotateOtherDimensions(
                            String[][][] newCube, String[][][] cube, int targetDimension) {
        if (targetDimension == 0) {
            return rotateSideDimensionsOfUp(newCube, cube);
        }
        if (targetDimension == 1) {
            return rotateSideDimensionsOfLeft(newCube, cube);
        }
        if (targetDimension == 2) {
            return rotateSideDimensionsOfFront(newCube, cube);
        }
        if (targetDimension == 3) {
            return rotateSideDimensionsOfRight(newCube, cube);
        }
        if (targetDimension == 4) {
            return rotateSideDimensionsOfBack(newCube, cube);
        }
        if (targetDimension == 5) {
            return rotateSideDimensionsOfDown(newCube, cube);
        }
        return newCube;
    }

    public String[][][] rotateSideDimensionsOfUp(String[][][] newCube, String[][][] cube) {
        for (int i = 1; i < cube.length - 1; i++) {
            for (int j = 0; j < cube[i][0].length; j++) {
                newCube[getTargetIndexOfSideDimensionsOfUp(i)][0][j] = cube[i][0][j];
            }
        }
        return newCube;
    }

    public int getTargetIndexOfSideDimensionsOfUp(int i) {
        int targetFirstIndex = i - 1;
        if (targetFirstIndex < 1) {
            targetFirstIndex = 4;
        }
        return targetFirstIndex;
    }

    public String[][][] rotateSideDimensionsOfLeft(String[][][] newCube, String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            newCube[2][i][0] = cube[0][i][0];
        }
        for (int i = 0; i < cube[2].length; i++) {
            newCube[5][i][0] = cube[2][i][0];
        }
        for (int i = 0; i < cube[5].length; i++) {
            newCube[4][i][2] = cube[5][cube[5].length - i - 1][0];
        }
        for (int i = 0; i < cube[4].length; i++) {
            newCube[0][cube[0].length - i - 1][0] = cube[4][i][2];
        }
        return newCube;
    }

    public String[][][] rotateSideDimensionsOfFront(String[][][] newCube, String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            newCube[3][i][0] = cube[0][2][i];
        }
        for (int i = 0; i < cube[3].length; i++) {
            newCube[5][0][cube[5].length - i - 1] = cube[3][i][0];
        }
        for (int i = 0; i < cube[5].length; i++) {
            newCube[1][i][2] = cube[5][0][i];
        }
        for (int i = 0; i < cube[1].length; i++) {
            newCube[0][2][cube[0].length - i - 1] = cube[1][i][2];
        }
        return newCube;
    }

    public String[][][] rotateSideDimensionsOfRight(String[][][] newCube, String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            newCube[4][i][0] = cube[0][cube[0].length - i - 1][2];
        }
        for (int i = 0; i < cube[4].length; i++) {
            newCube[5][cube[5].length - i - 1][2] = cube[4][i][0];
        }
        for (int i = 0; i < cube[5].length; i++) {
            newCube[2][i][2] = cube[5][i][2];
        }
        for (int i = 0; i < cube[0].length; i++) {
            newCube[0][i][2] = cube[2][i][2];
        }
        return newCube;
    }

    public String[][][] rotateSideDimensionsOfBack(String[][][] newCube, String[][][] cube) {
        for (int i = 0; i < cube[0].length; i++) {
            newCube[1][cube[1].length - i - 1][0] = cube[0][0][i];
        }
        for (int i = 0; i < cube[1].length; i++) {
            newCube[5][2][i] = cube[1][i][0];
        }
        for (int i = 0; i < cube[5].length; i++) {
            newCube[3][cube[3].length - i - 1][2] = cube[5][2][i];
        }
        for (int i = 0; i < cube[3].length; i++) {
            newCube[0][0][i] = cube[3][i][2];
        }
        return newCube;
    }

    public String[][][] rotateSideDimensionsOfDown(String[][][] newCube, String[][][] cube) {
        for (int i = 1; i < cube.length - 1; i++) {
            for (int j = 0; j < cube[i][0].length; j++) {
                newCube[getTargetIndexOfSideDimensionsOfDown(i)][2][j] = cube[i][2][j];
            }
        }
        return newCube;
    }

    public int getTargetIndexOfSideDimensionsOfDown(int i) {
        int targetFirstIndex = i + 1;
        if (targetFirstIndex > 4) {
            targetFirstIndex = 1;
        }
        return targetFirstIndex;
    }
}
