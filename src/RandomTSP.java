/**
 * Created by eliztekcan on 29.04.2018.
 */
public class RandomTSP {
    public static void main(String args[])
    {

        //AsymmetricTSP a_tsp = new AsymmetricTSP();
        //SymmetricTSP s_tsp = new SymmetricTSP();
        //EuclideanTSP e_tsp = new EuclideanTSP();

        /*TSPSolver e_solver = new TSPSolver("E");
        System.out.println("Solving the following Euclidean TSP");
        System.out.println();
        e_solver.nearestNeighbor();
        System.out.println();*/


        TSPSolver s_solver = new TSPSolver("S", 50, 2);
        System.out.println("Solving the following Symmetric TSP");
        System.out.println();
        s_solver.nearestNeighbor();
        System.out.println();


        System.out.println(s_solver.getTsp().visualizationData());




        /*TSPSolver a_solver = new TSPSolver("asymmetric");
        System.out.println("Solving the following Asymmetric TSP");
        System.out.println();
        a_solver.nearestNeighbor();
        System.out.println();*/


    }
}

