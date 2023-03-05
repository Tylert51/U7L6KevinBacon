/*
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW2 {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> d3 = new ArrayList<>();
        Collections.sort(d3);


        try {
            File f = new File("src/d3.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (String a : d3) {
                fw.write(a + "\n");
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }
    }
}