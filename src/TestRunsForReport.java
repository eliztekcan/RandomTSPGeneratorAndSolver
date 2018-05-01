import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eliztekcan on 29.04.2018.
 */
public class TestRunsForReport {
    public static void main(String args[])
    {
        System.out.println("This program runs various random test runs for varying size of" +
                " min and max values for nodes contained in the TSP");

        System.out.println("Example usage: y <TYPE> <MIN> <MAX>");
        System.out.println("<TYPE> A - a : Asymmetric TSP");
        System.out.println("<TYPE> S - s : Symmetric TSP");
        System.out.println("<TYPE> E - e : Euclidean TSP");

        System.out.println("Press any other button to quit");
        System.out.println("See the output in \"<TYPE>_<MIN>_<MAX>_test.txt\"");
        String input = "y";
        while(input.substring(0,1).equals("y"))
        {
            String type = "";
            int min, max = 0;
            input = "";
            Scanner scan = new Scanner(System.in);

            while(input.equals(""))
                input = scan.nextLine();

            if(!input.substring(0,1).equals("y"))
                break;



            String temp = input.substring(2);
            temp= temp.replace(' ', '_');
            System.out.println(temp);
            try {
                min = Integer.parseInt(middleText(temp, 1));
                max = Integer.parseInt(temp.substring(temp.lastIndexOf('_')+1));
            } catch (NumberFormatException e) {

                System.out.println("Wrong input format");

            }
            //System.out.println(min + "," + max);
            type = temp.substring(0,1);
            //System.out.println(type);

            temp.concat("_test.txt");

            WriteDatatoFile write = new WriteDatatoFile();
            write.writeOutput(temp);

            TSPSolver s_solver = new TSPSolver(type, max, 1);
            System.out.println("Solving the following Symmetric TSP");
            s_solver.nearestNeighbor();
            System.out.println(s_solver.getTsp().visualizationData());

            s_solver.nearestNeighbor();
        }
    }


    public static String middleText(String sentence, int n) {
        Pattern pattern = Pattern.compile("_(.*)_");
        Matcher matcher = pattern.matcher(sentence);
        if (matcher.find()) {
            return matcher.group(n);
        }
        else
            return "";
    }
}

