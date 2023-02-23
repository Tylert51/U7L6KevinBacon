import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<String> allD2Ac = MovieDatabaseBuilder.getActorDB("d2_actors.txt");

        try {
            File f = new File("src/d2_actors_sort.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            int counter = 1;
            for (String a : allD2Ac) {
                fw.write(a + "\n");
                System.out.println(counter + " / " + allD2Ac.size());
                counter++;
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }


    }
}
