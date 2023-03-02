import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<String> filler = new ArrayList<String>();


        try {
            File f = new File("src/filler.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (String a : filler) {
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
