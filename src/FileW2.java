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

        ArrayList<String> actorsLeft = MovieDatabaseBuilder.getActorDB("src/actorsLeft.txt");
        ArrayList<String> path = new ArrayList<>();

        ArrayList<String> d6 = MovieDatabaseBuilder.getActorDB("src/d6.txt");
        actorsLeft.removeAll(d6);


        Collections.sort(actorsLeft);

        try {
            File f = new File("src/actorsLeft.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (String a : actorsLeft) {
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