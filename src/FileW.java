import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
        ArrayList<String> allActors = new ArrayList<String>();

        for(SimpleMovie m : movies) {
            ArrayList<String> actors = m.getActors();

            for(String str : actors) {
                if(!allActors.contains(str)) {
                    allActors.add(str);
                }
            }
        }

        try {
            File f = new File("src/all_actors.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            for (String m : allActors) {
                fw.write(m + "\n");
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }


    }
}
