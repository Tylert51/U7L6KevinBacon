/*
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> d1 = MovieDatabaseBuilder.getActorDB("src/bacon_cast_mates.txt");
        ArrayList<String> d2 = MovieDatabaseBuilder.getActorDB("src/trueD2Act.txt");
        ArrayList<String> d3 = MovieDatabaseBuilder.getActorDB("src/d3.txt");
        ArrayList<String> d4A = MovieDatabaseBuilder.getActorDB("src/d4.txt");
        ArrayList<String> d5A = MovieDatabaseBuilder.getActorDB("src/d5.txt");

        ArrayList<Actor> allActors = MovieDatabaseBuilder.getActorMovieDB("src/actor_to_mov.txt");
        ArrayList<String> all = new ArrayList<>();
        ArrayList<String> left = new ArrayList<>();

        all.add("Kevin Bacon");
        all.addAll(d1);
        all.addAll(d2);
        all.addAll(d3);
        all.addAll(d4A);
        all.addAll(d5A);

        for(Actor a : allActors) {
            String act = a.getName();

            if(!all.contains(act)) {
                left.add(act);
            }
            System.out.println(counter + " / " + allActors.size());
            counter++;
        }

        try {
            File f = new File("src/actorsLeft.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (String a : left) {
                fw.write(a + "\n");
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }
    }
}