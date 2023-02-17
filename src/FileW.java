import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> allMov = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        ArrayList<String> allActors = new ArrayList<String>();

        for(SimpleMovie m : allMov) {
            ArrayList<String> actors = m.getActors();

            for(String str : actors) {
                if (!allActors.contains(str)) {
                    allActors.add(str);
                }
            }
        }

        Collections.sort(allActors);


        try {
            File f = new File("src/all_actors.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (String a : allActors) {
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
