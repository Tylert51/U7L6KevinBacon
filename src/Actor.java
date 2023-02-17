import java.util.ArrayList;

public class Actor implements Comparable<Actor> {
    private String name;
    private ArrayList<String> moviesStarred;

    public Actor (String n, ArrayList<String> m) {
        name = n;
        moviesStarred = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public ArrayList<String> getMoviesStarred() {
        return moviesStarred;
    }

    public String toString() {
        String str = name + "---";
        for(String m : moviesStarred) {
            str += m + ":";
        }

        return str;
    }


    public int compareTo(Actor other) {
        return other.getMoviesStarred().size() - getMoviesStarred().size();
    }



    /*
    public int compareTo(Actor other) {
        return name.compareTo(other.getName());
    }

     */
}
