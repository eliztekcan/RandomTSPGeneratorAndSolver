import java.util.Arrays;

/**
 * Created by eliztekcan on 29.04.2018.
 */
public class EuclideanVertex extends Vertex {

    EuclideanVertex(String name)
    {
        super(-1, -1, name);
        this.setX(randomCoordinate());
        this.setY(randomCoordinate());
    }

    private int randomCoordinate() {
        int range = 40 - 20 + 1; // max - min + 1
        int coordinate =  (int) (Math.random() * range); //max vertexSet count
        return coordinate;
    }

    @Override
    public String toString() {
        return  name +
                "(" + x +
                ", " + y +
                ")";
    }

    public void printVertex()
    {
        System.out.print( name + " (" + x + ", " + y + ") -> ");
    }


}
