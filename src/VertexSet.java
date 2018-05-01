import java.util.Arrays;

/**
 * Created by eliztekcan on 1.05.2018.
 */
public class VertexSet {
    Vertex[] vertexSet;
    int vertexCount;
    protected final int range; //max-min+1

    VertexSet(int max, int min)
    {
        range = max - min + 1;
        vertexCount = (int) (Math.random() * range) +2; //max vertexSet count
        vertexSet = new Vertex[vertexCount];
    }


    public Vertex[] getVertexSet() {
        return vertexSet;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public String toString() {
        String str = "{";
        for(int i = 0; i < vertexCount-1; i++)
            str += vertexSet[i].toString() + ", ";
        str += vertexSet[vertexCount-1].toString() + "}";
        return str;
    }
}
