import java.util.ArrayList;
import java.util.Scanner;

public class Bacon {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean bn2 = false;

        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies.txt");
        ArrayList<Actor> d2A = MovieDatabaseBuilder.getActorMovieDB("src/d2Act.txt");

        System.out.print("Welcome to the Degrees of Bacon Calculator\n\nEnter and actor's name or (q) to quit: ");

        ArrayList<Actor> allActorsSort= MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies_sorted.txt");


        String targActor = s.nextLine();
        ArrayList<String> path = new ArrayList<String>();

        while (!targActor.equals("q")) {
            int degree = 0;

            ArrayList<String> results = printActors(allActors, targActor);

            System.out.print("Which actor do you want to pick: ");
            int numPick = s.nextInt();
            String searchActor = results.get(numPick - 1);

            if (results.get(numPick - 1).equals("Kevin Bacon")) {
                System.out.println("Actor Chosen: " + results.get(numPick - 1));
                path.add(results.get(numPick - 1));
                printPath(path, degree);

            } else {   // degree 1

            }

            System.out.print("Enter and actor's name or (q) to quit: ");
            s.nextLine();
            targActor = s.nextLine();
            path.clear();
        }
    }

    public static int fullSearch(ArrayList<SimpleMovie> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getActors().contains(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearch1(ArrayList<Actor> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearch2(ArrayList<SimpleMovie> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(target)) {
                return i;
            }
        }

        return -1;
    }

    public static ArrayList<String> printActors(ArrayList<Actor> actors, String target) {
        ArrayList<String> results = new ArrayList<String>();

        int counter = 1;

        for (Actor a : actors) {
            if (a.getName().contains(target)) {
                System.out.println(counter + ". " + a.getName());
                counter++;
                results.add(a.getName());
            }
        }

        return results;
    }

    public static void printPath(ArrayList<String> p, int baconN) {
        String str = "";

        for (int i = 0; i < p.size(); i++) {
            str += p.get(i) + " -> ";
        }
        str += " Kevin Bacon";

        System.out.println(str);
        System.out.println("Bacon Number: " + baconN);


    }

}
