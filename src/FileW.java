import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {

        ArrayList<String> filler = new ArrayList<String>();




        try {
            File f = new File("src/d2Act.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            int counter = 1;
            for (String a : filler) {
                fw.write(a + "\n");
                System.out.println(counter + " / " + filler.size());
                counter++;
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }


    }
}
