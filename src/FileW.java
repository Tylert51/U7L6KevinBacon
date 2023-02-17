import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {


        ArrayList<Actor> allActorsSort= MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies_sorted.txt");
        ArrayList<String> baconCastMates = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<Actor> bacon = new ArrayList<Actor>();

        for(Actor a : allActorsSort) {
            String actor = a.getName();
            for (int i = 0; i < baconCastMates.size(); i++) {
                String castmate = baconCastMates.get(i);
                if(actor.equals(castmate)) {
                    bacon.add(a);
                    i = baconCastMates.size();
                }
            }
        }


        try {
            File f = new File("src/bacon_cast_sort.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (Actor a : bacon) {
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
