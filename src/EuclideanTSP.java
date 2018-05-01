/**
 * Created by eliztekcan on 29.04.2018.
 */
public class EuclideanTSP extends TSP{

    EuclideanTSP(int max, int min)
    {
        System.out.println("Creating Euclidean TSP with the following values:");
        vertexSet = new EuclideanVertexSet(max, min);
        vertexCount = vertexSet.getVertexCount();
        edge = new EuclideanEdge(vertexCount);
        distance = new double[vertexCount][vertexCount];


        for(int i = 0; i < vertexCount; i++){
            for(int j = 0; j < vertexCount; j ++){
                distance[i][j] = -1;
            }
        }

        for(int i = 0; i < vertexCount; i++){
            for(int j = 0; j < vertexCount; j ++){

                if(edge.getEdge()[i][j] == true)
                {
                    distance[i][j] = calculateDistance(i, j);
                }
            }
        }

        System.out.println(this.toString());
    }

    private double calculateDistance(int i, int j) {
        int x = vertexSet.getVertexSet()[i].getX() - vertexSet.getVertexSet()[j].getX();
        int y = vertexSet.getVertexSet()[i].getY() - vertexSet.getVertexSet()[j].getY();
        return Math.sqrt(x*x + y*y);
    }


    @Override
    public String toString() {
        String str = "\nVertexCount = " + vertexCount +
                "\n\nDistance array = \n\n";

        for(double[] row : distance) {
            str = str + printRow(row) + "\n";
        }

        str += "Vertex Set = Name(x, y)\n" + vertexSet +
                "\n\nEdge Set = (Name, Name)\n" + edge;

        return str;
    }



}
