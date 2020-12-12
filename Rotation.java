import direction.Clockwise;
import direction.CounterClockwise;

public class Rotation {

    Clockwise clockwise;
    CounterClockwise counterClockwise;
    
    Rotation() {
        clockwise = new Clockwise();
        counterClockwise = new CounterClockwise();
    }
    
    public String[][][] rotateClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = clockwise.rotateTargetDimension(newCube, cube, targetDimension);
        newCube = clockwise.rotateOtherDimensions(newCube, cube, targetDimension);
        return newCube;
    }

    public String[][][] rotateCounterClockwise(String[][][] cube, int targetDimension) {
        String[][][] newCube = new String[6][3][3];
        newCube = counterClockwise.rotateTargetDimension(newCube, cube, targetDimension);
        // newCube = rotateOtherDimensions(newCube, cube, targetDimension);
        return newCube;
    }
}
