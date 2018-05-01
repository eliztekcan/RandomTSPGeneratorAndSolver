import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 * Created by eliztekcan on 29.04.2018.
 */
public class SymmetricTSP extends TSP{
    SimpleWeightedGraph<String, DefaultWeightedEdge>  graph;

    SymmetricTSP (int max, int min)
    {
        System.out.println("Creating Symmetric TSP with the following values:");

        vertexSet = new SymmetryVertexSet(max, min);
        vertexCount = vertexSet.getVertexCount();
        edge = new SymmetricEdge(vertexCount);
        distance = new double[vertexCount][vertexCount];

        graph = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        for(int i = 0; i < vertexCount; i++){
            graph.addVertex(vertexSet.getVertexSet()[i].getName());
        }

        initializeRandomDistance();
        //edge.printEdgeArray();
        //printDistanceArray();
        System.out.println(this.toString());
        //edge.printEdgeArray();
    }

    private void initializeRandomDistance() {

        for(int i = 0; i < vertexCount; i++)
        {
            for (int j = 0; j < vertexCount; j++) {
                if(edge.getEdge()[i][j]){
                    DefaultWeightedEdge e1 = graph.addEdge(vertexSet.getVertexSet()[i].getName(), vertexSet.getVertexSet()[j].getName());
                    //System.out.print("E1: " + e1);
                    double weight = randomWeight();
                    if(e1 != null)
                        graph.setEdgeWeight(e1, weight);
                    distance[i][j] = weight;
                    distance[j][i] = weight;
                }
                else
                    distance[i][j] = -1;
            }
        }
    }


    public SimpleWeightedGraph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public void setGraph(SimpleWeightedGraph<String, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }
}
