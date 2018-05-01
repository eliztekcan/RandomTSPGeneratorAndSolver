import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

/**
 * Created by eliztekcan on 29.04.2018.
 */
public class AsymmetricTSP extends TSP{
    SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph;

    AsymmetricTSP (int max, int min)
    {
        System.out.println("Creating Asymmetric TSP with the following values:");

        graph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>
                        (DefaultWeightedEdge.class);
        vertexSet = new SymmetryVertexSet(max, min);
        vertexCount = vertexSet.getVertexCount();
        edge = new AsymmetricEdge(vertexCount);
        distance = new double[vertexCount][vertexCount];

        for(int i = 0; i < vertexCount; i++)
            graph.addVertex(vertexSet.getVertexSet()[i].getName());


        initializeRandomDistance();

        System.out.println(this.toString());

    }

    private void initializeRandomDistance() {

        for(int i = 0; i < vertexCount; i++)
        {
            for (int j = 0; j < vertexCount; j++) {
                if(edge.getEdge()[i][j]){
                    DefaultWeightedEdge e1 = graph.addEdge(vertexSet.getVertexSet()[i].getName(), vertexSet.getVertexSet()[j].getName());
                    double weight = randomWeight();
                    graph.setEdgeWeight(e1, weight);
                    distance[i][j] = weight;
                }
                else
                    distance[i][j] = -1;
            }
        }
    }

}
