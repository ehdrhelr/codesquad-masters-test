package cube;

import cube.direction.Clockwise;
import cube.direction.CounterClockwise;

public class Rotation {
    
    Rotation() {

    }
    
    public static String[][][] rotateClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = Clockwise.rotateTargetDimension(newCube, cube, targetDimension);
        newCube = Clockwise.rotateOtherDimensions(newCube, cube, targetDimension);
        return newCube;
    }

    public static String[][][] rotateCounterClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = CounterClockwise.rotateTargetDimension(newCube, cube, targetDimension);
        newCube = CounterClockwise.rotateOtherDimensions(newCube, cube, targetDimension);
        return newCube;
    }
}
