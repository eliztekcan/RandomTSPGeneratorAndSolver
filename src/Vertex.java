/**
 * Created by eliztekcan on 1.05.2018.
 */
public class Vertex {

    int x, y;
    String name;


    public Vertex(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printVertex()
    {
        System.out.print( name + " -> ");
    }

    @Override
    public String toString() {
        return  name;
    }
}
