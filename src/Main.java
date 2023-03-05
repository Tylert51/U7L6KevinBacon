import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        int index = 1;

        ArrayList<String> d4 = MovieDatabaseBuilder.getActorDB("src/d4.txt");
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> ind = new ArrayList<>();

        for(String a : d4) {
            int num = Bacon.calculate4(a, path);
            if (num == 0) {
                counter++;
            } else {
                ind.add(index + "");
            }
            System.out.println(index + " / " + d4.size());
            index++;
        }

        System.out.println(counter);
        System.out.println(d4.size());
        System.out.println(ind);
    }
}
