import java.util.ArrayList;
import java.util.Scanner;

public class DegreesOfBacon {
    public static void main(String[] args) {







    }

    public static ArrayList calculate() {
        Scanner s = new Scanner(System.in);
        boolean bn2 = false;

        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies.txt");

        System.out.print("Welcome to the Degrees of Bacon Calculator\n\nEnter and actor's name or (q) to quit: ");

        ArrayList<Actor> allActorsSort= MovieDatabaseBuilder.getActorMovieDB("src/all_actors_movies_sorted.txt");

        ArrayList<String> baconCastMates = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<String> baconCmSort = MovieDatabaseBuilder.getActorDB("src/bacon_cast_sort.txt");
        ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies_del.txt");
        ArrayList<SimpleMovie> allMoviesSort = MovieDatabaseBuilder.getMovieDB("src/movies_sorted_delimiter.txt");
        ArrayList<SimpleMovie> allMovies = MovieDatabaseBuilder.getMovieDB("src/movie_data");

        String targActor = s.nextLine();
        ArrayList<String> path = new ArrayList<String>();

        ArrayList<String> ac = new ArrayList<>();

        while (!targActor.equals("q")) {
            int degree = 0;

            ArrayList<String> results = printActors(allActors, targActor);
            System.out.print("Which actor do you want to pick: ");
            int numPick = s.nextInt();

            if(results.get(numPick - 1).equals("Kevin Bacon")) {
                System.out.println("Actor Chosen: " + results.get(numPick - 1));
                path.add(results.get(numPick -1 ));
                printPath(path, degree);

            } else {   // degree 1
                degree++;

                String searchAc = results.get(numPick - 1);
                int indxOfAct = binarySearch1(baconCastMates, searchAc);

                if (indxOfAct != -1) {

                    path.add(searchAc);
                    for(int i = 0; i < baconMovies.size(); i++) {
                        ArrayList<String> actors = baconMovies.get(i).getActors();
                        if(actors.contains(searchAc)) {
                            path.add(baconMovies.get(i).getTitle());
                            i = baconMovies.size();
                        }
                    }

                    printPath(path, degree);
                    System.out.println();
                    s.nextLine();
                } else {   // degree 2
                    degree++;
                    searchAc = results.get(numPick - 1);

                    for(int i = 0 ; i < baconCmSort.size(); i++) {
                        String bacActor = baconCmSort.get(i).split("---")[0];
                        int indxOfA = binarySearch2(allActors, bacActor);
                        ArrayList<String> movies = allActors.get(indxOfA).getMoviesStarred();

                        for (int j = 0; j < movies.size(); j++) {
                            String movieSearch = movies.get(j);
                            int indxOfMov = fullSearch2(allMoviesSort, movieSearch);
                            SimpleMovie mov = allMovies.get(indxOfMov);
                            ArrayList<String> lastLvlActors = (ArrayList<String>) mov.getActors().clone();

                            if(lastLvlActors.contains(searchAc)) {
                                path.add(searchAc);
                                path.add(mov.getTitle());
                                path.add(bacActor);

                                int indxOfBacAct = fullSearch(baconMovies, bacActor);
                                path.add(baconMovies.get(indxOfBacAct).getTitle());

                                printPath(path, degree);

                                i = baconCmSort.size();
                                j = movies.size();

                                bn2 = true;



                            }

                            ac.addAll(lastLvlActors);
                        }
                    }

                    System.out.println("Nope");


                }
            }

            System.out.print("Enter and actor's name or (q) to quit: ");
            targActor = s.nextLine();
            targActor = s.nextLine();
            path.clear();



        }

        return ac;
    }

    public static int binarySearch1(ArrayList<String> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right)
        {
            int middle = (left + right) / 2;

            if(list.get(middle).equals(target)) {
                return middle;
            } else {
                if (target.compareTo(list.get(middle)) < 0) {
                    right = middle - 1;

                } else if (target.compareTo(list.get(middle)) > 0) {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }

    public static int binarySearch2(ArrayList<Actor> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right)
        {
            int middle = (left + right) / 2;

            if(list.get(middle).getName().equals(target)) {
                return middle;
            } else {
                if (target.compareTo(list.get(middle).getName()) < 0) {
                    right = middle - 1;

                } else if (target.compareTo(list.get(middle).getName()) > 0) {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }

    public static int binarySearch3(ArrayList<SimpleMovie> list, String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right)
        {
            int middle = (left + right) / 2;

            if(list.get(middle).getTitle().equals(target)) {
                return middle;
            } else {
                if (target.compareTo(list.get(middle).getTitle()) < 0) {
                    right = middle - 1;

                } else if (target.compareTo(list.get(middle).getTitle()) > 0) {
                    left = middle + 1;
                }
            }
        }

        return -1;
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
