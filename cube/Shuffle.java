package cube;

public class Shuffle {

    public static final int INPUT = -2;

    public static String[] directions 
        = {"U", "U'", "L", "L'", "F", "F'", "R", "R'", "B", "B'", "D", "D'"};

    

    public static void start(String[][][] cube, Rotation rotation) {
        Main main = new Main();
        for (int i = 0; i < 100; i++) {
            int randomIndex = (int) (Math.random() * directions.length);
            String direction = directions[randomIndex];
            int targetDirection = main.getTargetDimensionByInput(direction);
            cube = getCube(direction, cube, rotation, targetDirection);
        }
        Printer.printCube(cube);
    }

    public static String[][][] getCube(
                String target, String[][][] cube, Rotation rotation, int targetDimension) {
        
        if (target.endsWith("'")) {
            cube = rotation.rotateCounterClockwise(cube, targetDimension);
        } else {
            cube = rotation.rotateClockwise(cube, targetDimension);
        }
        return cube;
    }
}