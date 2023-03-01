import java.util.ArrayList;
import java.util.Scanner;

public class Bacon {
    private Scanner s = new Scanner(System.in);
    private static ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov.txt");
    private static ArrayList<Actor> d2A = MovieDatabaseBuilder.getActorMovieDB("src/d2Act.txt");
    private static ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies_del.txt");
    private static ArrayList<String> baconCast = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
    private static ArrayList<Actor> baconCastMov = MovieDatabaseBuilder.getActorMovieDB("src/bacon_m_mov.txt");
    private static ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
    private static ArrayList<String> path = new ArrayList<String>();

    private static String searchAc;

    public static void calculate() {
        Scanner s = new Scanner(System.in);
        boolean bn2 = false;

        System.out.print("Welcome to the Degrees of Bacon Calculator\n\nEnter and actor's name or (q) to quit: ");

        String targActor = s.nextLine();

        while (!targActor.equals("q")) {
            int degree = 0;

            ArrayList<String> results = printActors(allActors, targActor);

            System.out.print("Which actor do you want to pick: ");
            int numPick = s.nextInt();
            searchAc = results.get(numPick - 1);

            if (searchAc.equals("Kevin Bacon")) {   // degree 0
                path.add("Kevin Bacon");
                printPath(path, degree);

            } else if (baconCast.contains(searchAc)) {   // degree 1
                degree++;

                int indOfAc = fullSearch1(baconCastMov, searchAc);
                path.add(searchAc);
                path.add(baconCastMov.get(indOfAc).getMoviesStarred().get(0));

                printPath(path, degree);
            } else  {    // degree 2
                degree = 2;

                for(int i = 0; i < baconCastMov.size(); i++) {
                    String actor = baconCastMov.get(i).getName();
                    ArrayList<String> movies = baconCastMov.get(i).getMoviesStarred();

                    for(int x = 0; x < movies.size(); x++) {
                        int indOfM = fullSearch2(allMovies, movies.get(x));
                        ArrayList<String> nextLvl = allMovies.get(indOfM).getActors();

                        if(nextLvl.contains(searchAc)) {
                            path.add(searchAc);
                            path.add(allMovies.get(indOfM).getTitle());
                            path.add(actor);

                            int indOfBac = fullSearch(baconMovies, actor);
                            path.add(baconMovies.get(indOfBac).getTitle());

                            x = movies.size();
                            i = baconCastMov.size();
                        }
                    }
                }

                printPath(path, degree);
            }


            System.out.print("Enter and actor's name or (q) to quit: ");
            s.nextLine();
            targActor = s.nextLine();
            path.clear();
        }
    }



    public static int fullSearch(ArrayList<SimpleMovie> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getActors().equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearch1(ArrayList<Actor> list , String target) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static int fullSearch2(ArrayList<SimpleMovie> list , String target) {
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
            str += p.get(i) + " -> ";
        }
        str += " Kevin Bacon";

        System.out.println(str);
        System.out.println("Bacon Number: " + baconN);


    }

}
