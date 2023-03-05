import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Bacon {
    private Scanner s = new Scanner(System.in);
    private static ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov.txt");
    private static ArrayList<String> d2A = MovieDatabaseBuilder.getActorDB("src/trueD2Act.txt");
    private static ArrayList<String> d3A = MovieDatabaseBuilder.getActorDB("src/d3.txt");
    private static ArrayList<String> d4A = MovieDatabaseBuilder.getActorDB("src/d4.txt");
    private static ArrayList<String> d5A = MovieDatabaseBuilder.getActorDB("src/d5.txt");
    private static ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies_del.txt");
    private static ArrayList<String> baconCast = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
    private static ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
    private static ArrayList<String> path = new ArrayList<String>();

    private static String searchAc;

    private final static String ANSI_BLUE = "\u001B[34m";
    private final static String ANSI_RESET = "\u001B[0m";

    public static void calculate() {
        Scanner s = new Scanner(System.in);
        boolean bn2 = false;

        System.out.print("Welcome to the Degrees of Bacon Calculator\n\nEnter and actor's name or (q) to quit: ");

        String targActor = s.nextLine();

        while (!targActor.equals("q")) {
            int degree = 0;

            ArrayList<String> results = printActors(allActors, targActor);
            while(results.size() == 0) {
                System.out.print("Not a valid actor. Re-enter another actor: ");
                targActor = s.nextLine();
                results = printActors(allActors, targActor);
            }

            System.out.print("Which actor do you want to pick: ");
            int numPick = s.nextInt();
            searchAc = results.get(numPick - 1);

            if (searchAc.equals("Kevin Bacon")) {   // degree 0
                path.add("Kevin Bacon");

            } else if (baconCast.contains(searchAc)) {   // degree 1
                degree++;

                calculate1(searchAc, path);

            } else if (d2A.contains(searchAc)) {      // degree 2
                degree = 2;

                calculate2(searchAc, path);

            } else if (d3A.contains(searchAc)) {  // degree 3
                degree = 3;

                calculate3(searchAc, path);
            } else if (d4A.contains(searchAc)) {   // degree 4
                degree = 4;

                calculate4(searchAc, path);
            } else if (d5A.contains(searchAc)) {  // degree 5
                degree = 5;

                calculate5(searchAc, path);
            } else {     // degree 6
                degree = 6;

                calculate6(searchAc, path);
            }


            System.out.println();
            printPath(path, degree);


            System.out.println();
            System.out.print("Enter and actor's name or (q) to quit: ");
            s.nextLine();
            targActor = s.nextLine();
            path.clear();
        }

    }

    public static int calculate1(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchMA(baconMovies, searchAc);

        if (indOfAc != -1) {
            path.add(searchAc);
            path.add(baconMovies.get(indOfAc).getTitle());
            return 0;
        }

        return -1;
    }

    public static int calculate2(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchA(allActors, searchAc);
        ArrayList<String> moviesStarred = allActors.get(indOfAc).getMoviesStarred();

        for(int i = 0; i < moviesStarred.size(); i++) {
            int indOfMov = fullSearchMT(allMovies, moviesStarred.get(i));
            if(indOfMov != -1) {
                ArrayList<String> actors = allMovies.get(indOfMov).getActors();

                for (int x = 0; x < actors.size(); x++) {
                    String currAct = actors.get(x);
                    if (baconCast.contains(currAct)) {
                        int indOfLast = baconCast.indexOf(currAct);

                        path.add(searchAc);
                        path.add(allMovies.get(indOfMov).getTitle());

                        searchAc = baconCast.get(indOfLast);
                        x = actors.size();
                        i = moviesStarred.size();
                    }
                }
            }
        }

       return calculate1(searchAc, path);
    }

    public static int calculate3(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchA(allActors, searchAc);
        ArrayList<String> moviesStarred = allActors.get(indOfAc).getMoviesStarred();

        for(int i = 0; i < moviesStarred.size(); i++) {
            int indOfMov = fullSearchMT(allMovies, moviesStarred.get(i));
            if(indOfMov != -1) {
                ArrayList<String> actors = allMovies.get(indOfMov).getActors();

                for (int x = 0; x < actors.size(); x++) {
                    String currAct = actors.get(x);

                    if (d2A.contains(currAct)) {
                        int indOfSec = d2A.indexOf(currAct);

                        path.add(searchAc);
                        path.add(allMovies.get(indOfMov).getTitle());

                        searchAc = d2A.get(indOfSec);

                        x = actors.size();
                        i = moviesStarred.size();
                    }
                }
            }
        }
        return calculate2(searchAc, path);
    }

    public static int calculate4(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchA(allActors, searchAc);
        ArrayList<String> moviesStarred = allActors.get(indOfAc).getMoviesStarred();

        for(int i = 0; i < moviesStarred.size(); i++) {
            int indOfMov = fullSearchMT(allMovies, moviesStarred.get(i));
            if(indOfMov != -1) {
                ArrayList<String> actors = allMovies.get(indOfMov).getActors();

                for (int x = 0; x < actors.size(); x++) {
                    String currAct = actors.get(x);

                    if (d3A.contains(currAct)) {
                        int indOfSec = d3A.indexOf(currAct);

                        path.add(searchAc);
                        path.add(allMovies.get(indOfMov).getTitle());

                        searchAc = d3A.get(indOfSec);

                        x = actors.size();
                        i = moviesStarred.size();
                    }
                }
            }
        }
        return calculate3(searchAc, path);
    }

    public static int calculate5(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchA(allActors, searchAc);
        ArrayList<String> moviesStarred = allActors.get(indOfAc).getMoviesStarred();

        for(int i = 0; i < moviesStarred.size(); i++) {
            int indOfMov = fullSearchMT(allMovies, moviesStarred.get(i));
            if(indOfMov != -1) {
                ArrayList<String> actors = allMovies.get(indOfMov).getActors();

                for (int x = 0; x < actors.size(); x++) {
                    String currAct = actors.get(x);

                    if (d4A.contains(currAct)) {
                        int indOfSec = d4A.indexOf(currAct);

                        path.add(searchAc);
                        path.add(allMovies.get(indOfMov).getTitle());

                        searchAc = d4A.get(indOfSec);

                        x = actors.size();
                        i = moviesStarred.size();
                    }
                }
            }
        }
        return calculate4(searchAc, path);
    }

    public static int calculate6(String searchAc, ArrayList<String> path) {
        int indOfAc = fullSearchA(allActors, searchAc);
        ArrayList<String> moviesStarred = allActors.get(indOfAc).getMoviesStarred();

        for(int i = 0; i < moviesStarred.size(); i++) {
            int indOfMov = fullSearchMT(allMovies, moviesStarred.get(i));
            if(indOfMov != -1) {
                ArrayList<String> actors = allMovies.get(indOfMov).getActors();

                for (int x = 0; x < actors.size(); x++) {
                    String currAct = actors.get(x);

                    if (d5A.contains(currAct)) {
                        int indOfSec = d5A.indexOf(currAct);

                        path.add(searchAc);
                        path.add(allMovies.get(indOfMov).getTitle());

                        searchAc = d5A.get(indOfSec);

                        x = actors.size();
                        i = moviesStarred.size();
                    }
                }
            }
        }
        return calculate5(searchAc, path);
    }

    public static int fullSearchMA(ArrayList<SimpleMovie> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getActors().contains(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearchA(ArrayList<Actor> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearchMT(ArrayList<SimpleMovie> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(target)) {
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
            if(i % 2 == 1) {
                str += ANSI_BLUE + p.get(i) + ANSI_RESET + " -> ";
            } else {
                str += p.get(i) + " -> ";
            }
        }
        str += "Kevin Bacon";

        System.out.println(str);
        System.out.println("Bacon Number: " + baconN);
    }
}
