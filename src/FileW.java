import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<Actor> allActMov = MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies_sorted.txt");



        Collections.sort(allActMov);


        try {
            File f = new File("src/all_actors_movies.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (Actor a : allActMov) {
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
