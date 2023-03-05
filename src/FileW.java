/*
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> d1 = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<String> d2 = MovieDatabaseBuilder.getActorDB("src/trueD2Act.txt");
        ArrayList<String> all = new ArrayList<>();
        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov.txt");
        ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");

        ArrayList<String> d3 = new ArrayList<>();

        all.add("Kevin Bacon");

        all.addAll((ArrayList<String>)d2.clone());
        all.addAll(d1);

        for(String a : d2) {
            int indOfAc = Bacon.fullSearchA(allActors, a);
            Actor actor = allActors.get(indOfAc);
            ArrayList<String> moviesS = actor.getMoviesStarred();

            for(String m : moviesS) {
                int indOfMov = Bacon.fullSearchMT(allMovies, m);
                SimpleMovie mov = allMovies.get(indOfMov);
                ArrayList<String> actors = mov.getActors();

                for(String act : actors) {
                    if(!all.contains(act) && !d3.contains(act)) {
                        d3.add(act);
                    }
                }
            }

            System.out.println(counter + " / " + d2.size());
            counter++;
        }


        try {
            File f = new File("src/filler.txt");
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