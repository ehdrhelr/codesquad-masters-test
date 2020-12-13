package cube;

public class Shuffle {

    public static final int INPUT = -2;

    public static String[] directions 
        = {"U", "U'", "L", "L'", "F", "F'", "R", "R'", "B", "B'", "D", "D'"};

    public static String[][][] start(String[][][] cube) {
        Main main = new Main();
        for (int i = 0; i < 100; i++) {
            int randomIndex = (int) (Math.random() * directions.length);
            String direction = directions[randomIndex];
            int targetDimension = main.getTargetDimensionByInput(direction);
            cube = getCube(direction, cube, targetDimension);
        }
        Printer.printCube(cube);
        return cube;
    }

    public static String[][][] getCube(
                String target, String[][][] cube, int targetDimension) {
        if (target.endsWith("'")) {
            cube = Rotation.rotateCounterClockwise(cube, targetDimension);
        } else {
            cube = Rotation.rotateClockwise(cube, targetDimension);
        }
        return cube;
    }
}