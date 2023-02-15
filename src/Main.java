import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        for (SimpleMovie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("Number of movies: " + movies.size());
    }
}
