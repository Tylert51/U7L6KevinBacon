import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> bMates = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov_sort.txt");
        ArrayList<Actor> bMatesMov = new ArrayList<>();

        for (String mate : bMates) {
            ArrayList<String> moviesStarred = new ArrayList<>();

            for(int i = 0; i < allActors.size(); i++) {
                String actor = allActors.get(i).getName();

                if(actor.contains(mate)) {
                    moviesStarred = (ArrayList<String>) allActors.get(i).getMoviesStarred().clone();
                    i = allActors.size();
                }
            }

            System.out.println(counter + " / " + bMates.size());
            counter++;

            bMatesMov.add(new Actor(mate, moviesStarred));
        }

        try {
            File f = new File("src/bacon_m_mov.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (Actor a : bMatesMov) {
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
