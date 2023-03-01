import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW2 {
    public static void main(String[] args) {
        int counter = 1;


        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov.txt");

        Collections.sort(allActors);

        try {
            counter = 1;
            File f = new File("src/actor_to_mov_sort.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (Actor a : allActors) {
                fw.write(a + "\n");
                System.out.println(counter + " / " + allActors.size());
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
