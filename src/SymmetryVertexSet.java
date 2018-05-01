/**
 * Created by eliztekcan on 29.04.2018.
 */
public class SymmetryVertexSet extends VertexSet {

    SymmetryVertexSet(int max, int min){
        super( max, min);
        for (int i = 0; i < vertexCount; i++) {
            vertexSet[i] = new Vertex(-1, -1, i + "");
        }
    }

}
