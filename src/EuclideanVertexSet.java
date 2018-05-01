/**
 * Created by eliztekcan on 1.05.2018.
 */
public class EuclideanVertexSet extends VertexSet{

    public EuclideanVertexSet(int max, int min) {
        super(max, min);
        for(int i = 0; i < vertexCount; i++){
            vertexSet[i] = new EuclideanVertex(i + "");
        }
    }

}
