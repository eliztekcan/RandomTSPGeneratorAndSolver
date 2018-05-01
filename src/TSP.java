import java.util.Arrays;

/**
 * Created by eliztekcan on 1.05.2018.
 */
public class TSP {
    int vertexCount;
    double [][] distance;
    VertexSet vertexSet;
    Edge edge;

    public int getVertexCount() {
        return vertexCount;
    }

    public VertexSet getVertexSet() {
        return vertexSet;
    }

    public void setVertexSet(VertexSet vertexSet) {
        this.vertexSet = vertexSet;
    }

    public void printDistanceArray()
    {
        for(int i = 0; i < vertexCount; i++)
        {
            for (int j = 0; j < vertexCount; j++){
                System.out.println("i , j , distance[i][j] " + i + " " + j + " " + distance[i][j]);
            }
        }
    }

    public double randomWeight() {
        int range = 20 - 1 + 1;// max - min + 1
        return (Math.random() * range) + 1; //max vertexSet count
    }

    public double[][] getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        String str = "\nVertexCount = " + vertexCount +
                "\n\nDistance array = \n\n";

        for(double[] row : distance) {
            str = str + printRow(row) + "\n";
        }

        str += "Vertex Set = Name \n" + vertexSet +
                "\n\nEdge Set = (Name, Name)\n" + edge;

        return str;
    }


    /*https://stackoverflow.com/questions/12845208/how-to-print-two-dimensional-array-like-table*/
    public static String printRow(double[] row) {
        String str = "";
        for (double i : row) {
            str += (int) i + "\t";
        }
        str += "\n";
        return str;
    }

    public String visualizationData()
    {

        String str = "[ ";
        for(int i = 0; i < vertexCount; i++){
            for(int j = 0; j < vertexCount; j++){
                if(edge.getEdge()[i][j])
                    str += "(" + i + ", " + j + ", " +
                            distance[i][j] +"), ";
            }
        }
        return str.substring(0, str.length()-2).concat("]");
    }
}
