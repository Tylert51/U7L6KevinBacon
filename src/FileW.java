import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<String> allActors = MovieDatabaseBuilder.getActorDB("src/all_actors.txt");
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
        ArrayList<Actor> actorMovies = new ArrayList<Actor>();


        for(String actor : allActors) {

            ArrayList<SimpleMovie> moviesStarred = new ArrayList<SimpleMovie>();

            for(SimpleMovie m : movies) {
                if(m.getActors().contains(actor)) {
                    moviesStarred.add(m);
                }
            }
            actorMovies.add(new Actor(actor, moviesStarred));
        }

        try {
            File f = new File("src/all_actors_movies.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (Actor a : actorMovies) {
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
