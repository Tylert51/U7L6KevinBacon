import java.util.ArrayList;

public class SimpleMovie implements Comparable<SimpleMovie> {
    private String title;
    private String actorsData;
    private ArrayList<String> actors;

    public SimpleMovie(String t, String a) {
        title = t;
        actorsData = a;
        actors = new ArrayList<String>();
        String[] tempActors = actorsData.split(":");
        for (int i = 0; i < tempActors.length; i++) {
            actors.add(tempActors[i]);
        }

    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Title: " + title + "\n" + "Actors: " + actors + "\n";
    }

    public String toString2() {
        String del = title + "---";
        for(String a : actors) {
            del += a + ":";
        }

        return del;
    }

    public int compareTo (SimpleMovie mov) {
        return mov.actors.size() - actors.size();
    }
}
