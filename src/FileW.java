import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> allActors = MovieDatabaseBuilder.getActorDB("src/all_actors.txt");
        ArrayList<Actor> actorToMov = new ArrayList<Actor>();
        ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");

        for (String act : allActors) {
            ArrayList<String> moviesStarred = new ArrayList<>();
            for (int i = 0; i < allMovies.size(); i++) {
                ArrayList<String> actors = allMovies.get(i).getActors();

                if (actors.contains(act)) {
                    moviesStarred.add(allMovies.get(i).getTitle());
                }
            }
            actorToMov.add(new Actor(act, moviesStarred));

            System.out.println(counter + " / " + allActors.size());
            counter++;
        }







        try {
            File f = new File("src/actor_to_mov.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            counter = 1;
            for (Actor a : actorToMov) {
                fw.write(a + "\n");
                System.out.println(counter + " / " + actorToMov.size());
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
