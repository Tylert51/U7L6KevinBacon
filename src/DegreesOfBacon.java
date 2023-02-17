import java.util.ArrayList;

public class DegreesOfBacon {
    public static void main(String[] args) {
        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies.txt");
        ArrayList<Actor> allActorsSort= MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies_sorted.txt");
        ArrayList<String> baconCastMates = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies_del.txt");
        ArrayList<SimpleMovie> allMoviesSort = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
        ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movie_data");



    }
}
