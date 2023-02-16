import java.util.ArrayList;

public class Actor {
    private String name;
    private ArrayList<SimpleMovie> moviesStarred;

    public Actor (String n, ArrayList<SimpleMovie> m) {
        name = n;
        moviesStarred = m;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SimpleMovie> getMoviesStarred() {
        return moviesStarred;
    }

    public String toString() {
        String str = name + "---";
        for(SimpleMovie m : moviesStarred) {
            str += m.getTitle() + ":";
        }

        return str;
    }
}
