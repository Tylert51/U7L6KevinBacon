import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class MovieDatabaseBuilder {

    public static ArrayList<SimpleMovie> getMovieDB(String fileName) {
        ArrayList<SimpleMovie> movies = new ArrayList<SimpleMovie>();
        try {
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("---");
                if (data.length > 1) {
                    SimpleMovie s = new SimpleMovie(data[0], data[1]);
                    movies.add(s);
                }

            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return movies;
    }

    public static ArrayList<String> getActorDB(String fileName) {
        ArrayList<String> actors = new ArrayList<String>();
        try {
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                actors.add(line);
            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return actors;
    }

    public static ArrayList<Actor> getActorMovieDB(String fileName) {
        ArrayList<Actor> actMov = new ArrayList<Actor>();
        try {
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                ArrayList<String> moviesStarred;
                String line = reader.nextLine();
                Actor a;
                if(line.contains("Michał Żebrowski")) {
                    String actor = "Michał Żebrowski <!--";
                    moviesStarred = new ArrayList<String>(List.of("Tajemnica Westerplatte"));
                    a = new Actor(actor, moviesStarred);

                } else if (line.contains("Chris Masterson")) {
                    String actor = "Chris Masterson<!--";
                    moviesStarred = new ArrayList<String>(List.of("Impulse (2010 film)"));
                    a = new Actor(actor, moviesStarred);

                } else {

                    String[] data = line.split("---");
                    String[] movies = data[1].split(":::");
                    moviesStarred = new ArrayList<String>(List.of(movies));
                    a = new Actor(data[0], moviesStarred);

                }
                actMov.add(a);
            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return actMov;
    }

    public static ArrayList<Integer> getIndexDB(String fileName) {
        ArrayList<Integer> index = new ArrayList<>();
        try {
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                index.add(Integer.parseInt(line));
            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return index;
    }
}