import java.util.Arrays;

/**
 * Created by eliztekcan on 1.05.2018.
 */
public class Edge {
    int vertexCount;
    boolean[][] edge;

    public Edge(int vertex_count) {
        this.vertexCount = vertex_count;
        edge = new boolean[vertex_count][vertex_count];
        initializeEdge();
        makeEdgesConnected();
    }

    private void initializeEdge() {
        for(int i = 0; i < vertexCount; i++)
        {
            for (int j = 0; j < vertexCount; j++){
                edge[i][j] = getRandomBoolean(i, j);
            }
        }
    }

    public int getVertex_count() {
        return vertexCount;
    }

    public void setVertex_count(int vertex_count) {
        this.vertexCount = vertex_count;
    }

    public boolean[][] getEdge() {
        return edge;
    }

    public void setEdge(boolean[][] edge) {
        this.edge = edge;
    }

    public boolean getRandomBoolean(int i, int j) { //for symmetric and asymmetric TSP
        if (i != j)
            return Math.random() < 0.5;
        else
            return false;
    }

    public void adjustSymmetry() {
        for(int i = 0; i < vertexCount; i++){
            for(int j = 0; j < vertexCount; j ++){
                if(this.getEdge()[i][j] == true){
                    this.getEdge()[j][i] = true;
                }
            }
        }
    }

    public void makeEdgesConnected() {
        for(int i = 0; i < vertexCount; i++){
            if(!checkRowForTrues(i))
            {
                this.getEdge()[i][chooseRandomVertex(i)] = true;
            }
        }
    }


    private boolean checkRowForTrues(int i)
    {
        for(int j = 0; j < vertexCount; j++){
            if(this.getEdge()[i][j] == true)
                return true;
        }
        return false;
    }

    private int chooseRandomVertex(int i)
    {
        int val = i;
        while ( val == i)
            val = (int) (Math.random() * vertexCount);
        return  val;
    }

    @Override
    public String toString() {
        String str = "{ ";
        for(int i = 0; i < vertexCount; i++){
            for(int j = 0; j < vertexCount; j++){
                if(edge[i][j])
                    str += "(" + i + ", " + j + "), ";
                if(i == j && i == vertexCount-1){
                    str +=  "(" + i + ", " + j + ") }\n";
                }
            }
        }
        return str;
    }

    public void printEdgeArray()
    {
        for(int i = 0; i < vertexCount; i++)
        {
            for (int j = 0; j < vertexCount; j++){
                System.out.println("i , j , edge[i][j] " + i + " " + j + " " + edge[i][j]);

            }
        }
    }
}
