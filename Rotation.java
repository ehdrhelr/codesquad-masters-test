public class Rotation {

    public String[][][] rotateClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = rotateMyDimension(newCube, cube, targetDimension);
        return newCube;
    }
    
    public String[][][] rotateMyDimension(
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
}
