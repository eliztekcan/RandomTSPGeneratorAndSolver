//https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
//https://stackoverflow.com/questions/1994255/how-to-write-console-output-to-a-txt-file

import java.io.*;

public class WriteDatatoFile {


    public void writeOutput(String filename) {
        try {

            File file = new File(filename); //Your file
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);

        } catch (IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }


}