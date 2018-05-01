import java.util.Stack;

/**
 * Created by eliztekcan on 1.05.2018.
 */


/*

https://pdfs.semanticscholar.org/0495/1cef79d52e8a22b1dba8813a923225fb93ac.pdf
Algorithm 2: TSP using Greedy Approach
Step1: Look at all the arcs with minimum distance.
Step 2: Choose the n cheapest arcs
Step 3: List the distance of arcs starting from the minimum distance to maximum distance.
Step 4: Draw and check if it forms a Hamiltonian cycle.
Step 5: If step 4 forms a Hamiltonian cycle than we have an optimal solution; write down the
tour of the optimal solution and calculate their distance.

* */


/*
The 2-column vector contains cities' coordinates. The algorithm generates the optimal path to visit all the cities exactly once, and return to the starting city.
Do for all the cities:
1. select a city as current city.
2. find out the shortest edge connecting the current city and an unvisited city.
3. set the new city as current city.
4. mark the previous current city as visited.
5. if all the cities are visited, then terminate.
6. Go to step 2.

The algorithm has its limitations, and based on the cities' distribution on the map it may or may not give the optimal solution.

It resolves the problem of the equally distant cities, that some other submitted files had
* */
public class TSPSolver {
    private int vertexCount;
    private Stack<Vertex> stack;
    TSP tsp;

    TSPSolver(String type, int max, int min){
        stack = new Stack<Vertex>();
        if(type.toLowerCase().equals("e") || type.toLowerCase().equals("euclidean"))
            tsp = new EuclideanTSP(max, min);
        else if(type.toLowerCase().equals("s") || type.toLowerCase().equals("symmetric"))
            tsp = new SymmetricTSP(max, min);
        else if(type.toLowerCase().equals("a") || type.toLowerCase().equals("asymmetric"))
            tsp = new AsymmetricTSP(max, min);

        vertexCount = tsp.getVertexCount();
    }

    /*https://github.com/dray92/DataAnalysis/blob/master/TSPNearestNeighbour.java*/
    public void nearestNeighbor(){
        System.out.println("Nearest neighbor heuristic result: ");
        boolean[] visited;
        Vertex element;
        Vertex destination;
        double[][] cost;
        int i;
        double min;
        boolean flag;
        Vertex v;

        v = tsp.getVertexSet().getVertexSet()[0];
        destination = v;
        visited = new boolean[vertexCount + 1];
        flag = false;
        cost = tsp.getDistance();

        v.printVertex();

        visited[0] = true;
        stack.push(v);

        while( !stack.isEmpty()){
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while( i < vertexCount)
            {
                int index = Integer.parseInt(element.getName());
                if( cost[index][i] > 0 && visited[i] == false &&  min > cost[index][i])
                {
                    min = cost[index][i];
                    destination = tsp.getVertexSet().getVertexSet()[i];
                    flag = true;

                }
                i+=1;
            }

            if(flag)
            {
                visited[Integer.parseInt(destination.getName())] = true;
                stack.push(destination);
                destination.printVertex();
                flag = false;
                continue;
            }
            stack.pop();
        }
        System.out.println(tsp.getVertexSet().getVertexSet()[0]);
    }


    public TSP getTsp() {
        return tsp;
    }

}
